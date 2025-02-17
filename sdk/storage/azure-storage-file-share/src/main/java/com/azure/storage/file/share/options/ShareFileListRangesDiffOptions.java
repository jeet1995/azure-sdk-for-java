// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.file.share.options;

import com.azure.core.annotation.Fluent;
import com.azure.storage.common.implementation.StorageImplUtils;
import com.azure.storage.file.share.models.ShareFileRange;
import com.azure.storage.file.share.models.ShareRequestConditions;

/**
 * Extended options that may be passed when listing ranges for a File.
 */
@Fluent
public class ShareFileListRangesDiffOptions {
    private ShareFileRange range;
    private final String previousSnapshot;
    private ShareRequestConditions requestConditions;
    private Boolean supportRename;

    /**
     * Creates a new instance of {@link ShareFileListRangesDiffOptions}.
     *
     * @param previousSnapshot Specifies that the response will contain only ranges that were changed between target
     * file and previous snapshot. Changed ranges include both updated and cleared ranges. The target file may be a
     * snapshot, as long as the snapshot specified by previousSnapshot is the older of the two.
     * @throws NullPointerException If {@code previousSnapshot} is null.
     */
    public ShareFileListRangesDiffOptions(String previousSnapshot) {
        StorageImplUtils.assertNotNull("previousSnapshot", previousSnapshot);
        this.previousSnapshot = previousSnapshot;
    }

    /**
     * Gets the range of bytes over which to list ranges, inclusively.
     *
     * @return The range of bytes over which to list ranges, inclusively.
     */
    public ShareFileRange getRange() {
        return range;
    }

    /**
     * Sets the range of bytes over which to list ranges, inclusively.
     *
     * @param range The range of bytes over which to list ranges, inclusively.
     * @return The updated options.
     */
    public ShareFileListRangesDiffOptions setRange(ShareFileRange range) {
        this.range = range;
        return this;
    }

    /**
     * Gets the previous snapshot to compare to.
     *
     * @return The previous snapshot to compare to.
     */
    public String getPreviousSnapshot() {
        return previousSnapshot;
    }

    /**
     * Gets the {@link ShareRequestConditions}.
     *
     * @return {@link ShareRequestConditions}
     */
    public ShareRequestConditions getRequestConditions() {
        return requestConditions;
    }

    /**
     * Sets the {@link ShareRequestConditions}.
     *
     * @param requestConditions {@link ShareRequestConditions} for the file.
     * @return The updated options.
     */
    public ShareFileListRangesDiffOptions setRequestConditions(ShareRequestConditions requestConditions) {
        this.requestConditions = requestConditions;
        return this;
    }

    /**
     * Gets the supportRename value.
     *
     * @return Whether the changed ranges for a file that has been renamed or moved between the target snapshot
     * (or the live file) and the previous snapshot should be listed.
     */
    public Boolean isRenameIncluded() {
        return supportRename;
    }

    /**
     * Sets the value for whether the changed ranges for a file that has been renamed or moved should appear in the
     * snapshot dif.
     *
     * @param renameIncluded Whether the changed ranges for a file that has been renamed or moved between the target
     * snapshot (or the live file) and the previous snapshot should be listed.
     * @return The updated options.
     */
    public ShareFileListRangesDiffOptions setRenameIncluded(Boolean renameIncluded) {
        this.supportRename = renameIncluded;
        return this;
    }
}
