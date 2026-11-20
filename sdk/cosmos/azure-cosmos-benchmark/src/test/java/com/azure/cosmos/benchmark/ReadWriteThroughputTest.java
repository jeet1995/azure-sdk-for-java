// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.benchmark;

import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosContainer;
import com.azure.cosmos.models.CosmosItemRequestOptions;
import com.azure.cosmos.models.PartitionKey;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class ReadWriteThroughputTest {
    @Test(groups = "unit")
    public void asyncAlternatesDespiteCreateFailuresAndCyclesThroughReadPool() throws Exception {
        AsyncWriteBenchmark benchmark = mock(AsyncWriteBenchmark.class, CALLS_REAL_METHODS);
        CosmosAsyncContainer container = mock(CosmosAsyncContainer.class);
        initialize(benchmark, AsyncBenchmark.class, container);
        when(container.createItem(any(PojoizedJson.class), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class))).thenReturn(Mono.error(new IllegalStateException("injected")));
        when(container.readItem(any(String.class), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class), eq(PojoizedJson.class))).thenReturn(Mono.empty());

        for (long i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                final long index = i;
                assertThatThrownBy(() -> benchmark.performWorkload(index).block())
                    .isInstanceOf(IllegalStateException.class).hasMessage("injected");
            } else {
                benchmark.performWorkload(i).block();
            }
        }
        verify(container, times(4)).createItem(any(PojoizedJson.class), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class));
        verify(container, times(2)).readItem(eq("seed-0"), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class), eq(PojoizedJson.class));
        verify(container, times(2)).readItem(eq("seed-1"), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class), eq(PojoizedJson.class));
        verifyNoMoreInteractions(container);
    }

    @Test(groups = "unit")
    public void syncAlternatesCreatesAndReadsWithoutQueries() throws Exception {
        SyncWriteBenchmark benchmark = mock(SyncWriteBenchmark.class, CALLS_REAL_METHODS);
        CosmosContainer container = mock(CosmosContainer.class);
        initialize(benchmark, SyncBenchmark.class, container);
        for (long i = 0; i < 8; i++) {
            benchmark.performWorkload(i);
        }
        verify(container, times(4)).createItem(any(PojoizedJson.class), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class));
        verify(container, times(2)).readItem(eq("seed-0"), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class), eq(PojoizedJson.class));
        verify(container, times(2)).readItem(eq("seed-1"), any(PartitionKey.class),
            any(CosmosItemRequestOptions.class), eq(PojoizedJson.class));
        verifyNoMoreInteractions(container);
    }

    @DataProvider
    public Object[][] readPoolSizes() {
        return new Object[][] {{-1}, {0}, {1}};
    }

    @Test(groups = "unit", dataProvider = "readPoolSizes")
    public void validatesReadPoolBeforeSetup(int size) throws Exception {
        Path path = Files.createTempFile("read-write-config", ".json");
        try {
            String json = "{\"orchestrator\":{\"tenants\":[{\"id\":\"mixed\",\"serviceEndpoint\":"
                + "\"https://example.com\",\"masterKey\":\"test-key\",\"databaseId\":\"db\","
                + "\"containerId\":\"items\",\"operation\":\"ReadWriteThroughput\","
                + "\"numberOfPreCreatedDocuments\":" + size + "}]}}";
            Files.write(path, json.getBytes(StandardCharsets.UTF_8));
            if (size < 1) {
                assertThatThrownBy(() -> BenchmarkConfig.fromFile(path.toFile()))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("ReadWriteThroughput requires numberOfPreCreatedDocuments >= 1");
            } else {
                assertThat(BenchmarkConfig.fromFile(path.toFile()).getTenantWorkloads().get(0).getOperationType())
                    .isEqualTo(Operation.ReadWriteThroughput);
            }
        } finally {
            Files.deleteIfExists(path);
        }
    }

    private static void initialize(Object benchmark, Class<?> base, Object container) throws Exception {
        TenantWorkloadConfig config = new TenantWorkloadConfig();
        config.setOperation("ReadWriteThroughput");
        List<PojoizedJson> docs = Arrays.asList(
            BenchmarkHelper.generateDocument("seed-0", "value", "pk", 1),
            BenchmarkHelper.generateDocument("seed-1", "value", "pk", 1));
        setField(benchmark, base, "workloadConfig", config);
        setField(benchmark, base, "docsToRead", docs);
        setField(benchmark, base, "partitionKey", "pk");
        setField(benchmark, base, base == AsyncBenchmark.class ? "cosmosAsyncContainer" : "cosmosContainer", container);
        setField(benchmark, benchmark instanceof AsyncWriteBenchmark ? AsyncWriteBenchmark.class
            : SyncWriteBenchmark.class, "uuid", "create-");
        setField(benchmark, benchmark instanceof AsyncWriteBenchmark ? AsyncWriteBenchmark.class
            : SyncWriteBenchmark.class, "dataFieldValue", "value");
    }

    private static void setField(Object target, Class<?> owner, String name, Object value) throws Exception {
        Field field = owner.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }
}
