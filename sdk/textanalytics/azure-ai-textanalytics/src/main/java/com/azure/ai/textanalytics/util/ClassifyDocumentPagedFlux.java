// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics.util;

import com.azure.core.annotation.Immutable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.util.paging.ContinuablePagedFluxCore;
import com.azure.core.util.paging.PageRetriever;

import java.util.function.Supplier;

/**
 * An implementation of {@code ContinuablePagedFluxCore} that uses default {@link PagedResponse}.
 *
 * @see ContinuablePagedFluxCore
 */
@Immutable
public final class ClassifyDocumentPagedFlux extends
    ContinuablePagedFluxCore<String, ClassifyDocumentResultCollection, PagedResponse<ClassifyDocumentResultCollection>> {
    /**
     * Creates an instance of {@code ClassifyDocumentPagedFlux}
     *
     * @param pageRetrieverProvider a provider that returns {@link PageRetriever}
     */
    public ClassifyDocumentPagedFlux(
        Supplier<PageRetriever<String, PagedResponse<ClassifyDocumentResultCollection>>> pageRetrieverProvider) {
        super(pageRetrieverProvider);
    }
}
