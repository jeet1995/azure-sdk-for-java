// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.data.cosmos.repository.support;

import com.azure.cosmos.models.SqlParameter;
import com.azure.cosmos.models.SqlQuerySpec;
import com.azure.spring.data.cosmos.core.ReactiveCosmosOperations;
import com.azure.spring.data.cosmos.core.query.CosmosQuery;
import com.azure.spring.data.cosmos.repository.query.AbstractReactiveCosmosQuery;
import com.azure.spring.data.cosmos.repository.query.ReactiveCosmosParameterAccessor;
import com.azure.spring.data.cosmos.repository.query.ReactiveCosmosParameterParameterAccessor;
import com.azure.spring.data.cosmos.repository.query.ReactiveCosmosQueryMethod;
import com.azure.spring.data.cosmos.repository.query.SimpleReactiveCosmosEntityMetadata;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Parameter;
import org.springframework.data.repository.query.ResultProcessor;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.azure.spring.data.cosmos.core.convert.MappingCosmosConverter.toCosmosDbValue;

/**
 * Cosmos query class to handle the annotated queries. This overrides the execution and runs the query directly
 */
public class StringBasedReactiveCosmosQuery extends AbstractReactiveCosmosQuery {

    private final String query;

    /**
     * Constructor
     * @param queryMethod the query method
     * @param dbOperations the reactive cosmos operations
     */
    public StringBasedReactiveCosmosQuery(ReactiveCosmosQueryMethod queryMethod,
                                          ReactiveCosmosOperations dbOperations) {
        super(queryMethod, dbOperations);
        this.query = queryMethod.getQueryAnnotation();
    }

    @Override
    protected CosmosQuery createQuery(ReactiveCosmosParameterAccessor accessor) {
        return null;
    }

    @Override
    public Object execute(final Object[] parameters) {
        final ReactiveCosmosParameterAccessor accessor = new ReactiveCosmosParameterParameterAccessor(getQueryMethod(),
                                                                                              parameters);
        final ResultProcessor processor = getQueryMethod().getResultProcessor().withDynamicProjection(accessor);

        /*
         * The below for loop is used to handle two unique use cases with annotated queries.
         * Annotated queries are defined as strings so there is no way to know the clauses
         * being used in advance. Some clauses expect an array and others expect just a list of values.
         * (1) IN clauses expect the syntax 'IN (a, b, c) which is generated from the if statement.
         * (2) ARRAY_CONTAINS expects the syntax 'ARRAY_CONTAINS(["a", "b", "c"], table.param) which
         *     is generated from the else statement.
         */
        String expandedQuery = query;
        List<SqlParameter> sqlParameters = new ArrayList<>();
        String modifiedExpandedQuery = expandedQuery.toLowerCase(Locale.US).replaceAll("\\s+", "");
        for (int paramIndex = 0; paramIndex < parameters.length; paramIndex++) {
            Parameter queryParam = getQueryMethod().getParameters().getParameter(paramIndex);
            String paramName = queryParam.getName().orElse("");
            if (!("").equals(paramName)) {
                String inParamCheck = "array_contains(@" + paramName.toLowerCase(Locale.US);
                if (parameters[paramIndex] instanceof Collection  && !modifiedExpandedQuery.contains(inParamCheck)) {
                    List<Object> expandParam = ((Collection<?>) parameters[paramIndex]).stream().collect(Collectors.toList());
                    List<String> expandedParamKeys = new ArrayList<>();
                    for (int arrayIndex = 0; arrayIndex < expandParam.size(); arrayIndex++) {
                        expandedParamKeys.add("@" + paramName + arrayIndex);
                        sqlParameters.add(new SqlParameter("@" + paramName + arrayIndex, toCosmosDbValue(expandParam.get(arrayIndex))));
                    }
                    expandedQuery = expandedQuery.replaceAll("@" + queryParam.getName().orElse(""), String.join(",", expandedParamKeys));
                } else {
                    if (!Pageable.class.isAssignableFrom(queryParam.getType())
                        && !Sort.class.isAssignableFrom(queryParam.getType())) {
                        if (!(parameters[paramIndex] instanceof Optional<?>)
                            || (parameters[paramIndex] instanceof Optional<?>
                            && ((Optional<?>) parameters[paramIndex]).isPresent())) {
                            sqlParameters.add(new SqlParameter("@" + queryParam.getName().orElse(""), toCosmosDbValue(parameters[paramIndex])));
                        }
                    }
                }
            }
        }

        SqlQuerySpec querySpec = new SqlQuerySpec(stripExtraWhitespaceFromString(expandedQuery), sqlParameters);
        if (isCountQuery()) {
            final String container = ((SimpleReactiveCosmosEntityMetadata<?>) getQueryMethod().getEntityInformation()).getContainerName();
            return this.operations.count(querySpec, container);
        } else if (isSumQuery()) {
            final String container = ((SimpleReactiveCosmosEntityMetadata<?>) getQueryMethod().getEntityInformation()).getContainerName();
            return this.operations.sum(querySpec, container);
        } else {
            Flux<?> flux = this.operations.runQuery(querySpec, accessor.getSort(), processor.getReturnedType().getDomainType(),
                                                    processor.getReturnedType().getReturnedType());
            return flux;
        }
    }

    private String stripExtraWhitespaceFromString(String input) {
        return input.replaceAll("\\s+{1,}", " ").trim();
    }

    @Override
    protected boolean isDeleteQuery() {
        return false;
    }

    @Override
    protected boolean isExistsQuery() {
        return false;
    }

    protected boolean isCountQuery() {
        return StringBasedCosmosQuery.isCountQuery(query, getQueryMethod().getReturnedObjectType());
    }

    /**
     * This method is used to determine if the query is a sum query.
     * @return boolean if the query is a sum query
     */
    protected boolean isSumQuery() {
        return StringBasedCosmosQuery.isSumQuery(query, getQueryMethod().getReturnedObjectType());
    }

}
