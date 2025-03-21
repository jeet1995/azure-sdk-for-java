// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.search.documents.models;

import java.util.Objects;

/**
 * Configuration for how semantic search captions search results.
 */
public final class QueryCaption {
    private final QueryCaptionType captionType;
    private Boolean highlightEnabled;
    private Integer maxCharLength;

    /**
     * Creates a new instance of {@link QueryCaption}.
     *
     * @param captionType The type of captions to generate.
     */
    public QueryCaption(QueryCaptionType captionType) {
        this.captionType = Objects.requireNonNull(captionType, "'captionType' cannot be null.");
    }

    /**
     * Gets the type of captions to generate.
     *
     * @return The type of captions to generate.
     */
    public QueryCaptionType getCaptionType() {
        return captionType;
    }

    /**
     * Whether to highlight the captioned text in the result.
     *
     * @return Whether to highlight the captioned text in the result.
     */
    public Boolean isHighlightEnabled() {
        return highlightEnabled;
    }

    /**
     * Sets whether to highlight the captioned text in the result.
     *
     * @param highlightEnabled Whether to highlight the captioned text in the result.
     * @return The QueryCaption object itself.
     */
    public QueryCaption setHighlightEnabled(Boolean highlightEnabled) {
        this.highlightEnabled = highlightEnabled;
        return this;
    }

    /**
     * Gets the maximum number of characters to include in the caption.
     *
     * @return The maximum number of characters to include in the caption.
     */
    public Integer getMaxCharLength() {
        return maxCharLength;
    }

    /**
     * Sets the maximum number of characters to include in the caption.
     *
     * @param maxCharLength The maximum number of characters to include in the caption.
     * @return The QueryCaption object itself.
     */
    public QueryCaption setMaxCharLength(Integer maxCharLength) {
        this.maxCharLength = maxCharLength;
        return this;
    }
}
