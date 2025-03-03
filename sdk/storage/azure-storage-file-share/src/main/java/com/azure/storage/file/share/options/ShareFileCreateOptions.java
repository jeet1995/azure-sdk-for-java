// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.file.share.options;

import com.azure.core.annotation.Fluent;
import com.azure.storage.file.share.FileSmbProperties;
import com.azure.storage.file.share.models.FilePermissionFormat;
import com.azure.storage.file.share.models.FilePosixProperties;
import com.azure.storage.file.share.models.ShareFileHttpHeaders;
import com.azure.storage.file.share.models.ShareRequestConditions;
import java.util.Map;

/**
 * Extended options that may be passed when creating a share.
 */
@Fluent
public class ShareFileCreateOptions {

    private final long size;
    private ShareFileHttpHeaders httpHeaders;
    private FileSmbProperties smbProperties;
    private String filePermissionKey;
    private FilePermissionFormat filePermissionFormat;
    private Map<String, String> metadata;
    private ShareRequestConditions requestConditions;
    private FilePosixProperties posixProperties;

    /**
     * Creates a new instance of {@link ShareFileCreateOptions}.
     *
     * @param size Specifies the maximum size for the file share.
     */
    public ShareFileCreateOptions(long size) {
        this.size = size;
    }

    /**
     * Gets the maximum size for the file share.
     *
     * @return Specifies the maximum size for the file share.
     */
    public long getSize() {
        return this.size;
    }

    /**
     * Gets the file's http headers.
     *
     * @return the file's http headers.
     */
    public ShareFileHttpHeaders getShareFileHttpHeaders() {
        return httpHeaders;
    }

    /**
     * Sets the file's http headers.
     *
     * @param headers the http headers.
     * @return the updated options.
     */
    public ShareFileCreateOptions setShareFileHttpHeaders(ShareFileHttpHeaders headers) {
        httpHeaders = headers;
        return this;
    }

    /**
     * Gets the optional SMB properties to set on the destination file or directory.
     *
     * @return Optional SMB properties to set on the destination file or directory. The only properties that are
     * considered are file attributes, file creation time, file last write time, and file permission key. The rest are
     * ignored.
     */
    public FileSmbProperties getSmbProperties() {
        return smbProperties;
    }

    /**
     * Sets the optional SMB properties to set on the destination file or directory.
     *
     * @param smbProperties Optional SMB properties to set on the destination file or directory. The only properties
     * that are  considered are file attributes, file creation time, file last write time, and file permission key. The
     * rest are ignored.
     * @return The updated options.
     */
    public ShareFileCreateOptions setSmbProperties(FileSmbProperties smbProperties) {
        this.smbProperties = smbProperties;
        return this;
    }

    /**
     * Gets the metadata to associate with the share.
     *
     * @return Metadata to associate with the share
     */
    public Map<String, String> getMetadata() {
        return metadata;
    }

    /**
     * Sets the metadata to associate with the share.
     *
     * @param metadata Metadata to associate with the share. If there is leading or trailing whitespace in any
     * metadata key or value, it must be removed or encoded.
     * @return The updated options.
     */
    public ShareFileCreateOptions setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
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
     * @param requestConditions {@link ShareRequestConditions}
     * @return The updated options.
     */
    public ShareFileCreateOptions setRequestConditions(ShareRequestConditions requestConditions) {
        this.requestConditions = requestConditions;
        return this;
    }

    /**
     * Gets the file permission.
     *
     * @return file permission.
     */
    public String getFilePermission() {
        return filePermissionKey;
    }

    /**
     * Sets the file permission.
     *
     * @param filePermissionKey the file permission.
     * @return The updated options.
     */
    public ShareFileCreateOptions setFilePermission(String filePermissionKey) {
        this.filePermissionKey = filePermissionKey;
        return this;
    }

    /**
     * Gets the file permission format.
     *
     * @return file permission format.
     */
    public FilePermissionFormat getFilePermissionFormat() {
        return filePermissionFormat;
    }

    /**
     * Sets the file permission format.
     *
     * @param filePermissionFormat the file permission format.
     * @return The updated options.
     */
    public ShareFileCreateOptions setFilePermissionFormat(FilePermissionFormat filePermissionFormat) {
        this.filePermissionFormat = filePermissionFormat;
        return this;
    }

    /**
     *  Optional properties to set on NFS files.
     *  Note that this property is only applicable to files created in NFS shares.
     *
     * @return {@link FilePosixProperties}
     */
    public FilePosixProperties getPosixProperties() {
        return posixProperties;
    }

    /**
     *  Optional properties to set on NFS files.
     *  Note that this property is only applicable to files created in NFS shares.
     *
     * @param posixProperties {@link FilePosixProperties}
     * @return The updated options.
     */
    public ShareFileCreateOptions setPosixProperties(FilePosixProperties posixProperties) {
        this.posixProperties = posixProperties;
        return this;
    }
}
