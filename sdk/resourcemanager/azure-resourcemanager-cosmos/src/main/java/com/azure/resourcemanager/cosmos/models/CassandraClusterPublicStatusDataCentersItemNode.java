// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The CassandraClusterPublicStatusDataCentersItemNode model.
 */
@Fluent
public final class CassandraClusterPublicStatusDataCentersItemNode
    implements JsonSerializable<CassandraClusterPublicStatusDataCentersItemNode> {
    /*
     * The node's IP address.
     */
    private String address;

    /*
     * The state of the node in Cassandra ring.
     */
    private NodeState state;

    /*
     * The status property.
     */
    private String status;

    /*
     * Cassandra service status on this node
     */
    private String cassandraProcessStatus;

    /*
     * The amount of file system data in the data directory (e.g., 47.66 kB), excluding all content in the snapshots
     * subdirectories. Because all SSTable data files are included, any data that is not cleaned up (such as TTL-expired
     * cells or tombstones) is counted.
     */
    private String load;

    /*
     * List of tokens this node covers.
     */
    private List<String> tokens;

    /*
     * The size property.
     */
    private Integer size;

    /*
     * The network ID of the node.
     */
    private String hostId;

    /*
     * The rack this node is part of.
     */
    private String rack;

    /*
     * The timestamp when these statistics were captured.
     */
    private String timestamp;

    /*
     * The amount of disk used, in kB, of the directory /var/lib/cassandra.
     */
    private Long diskUsedKB;

    /*
     * The amount of disk free, in kB, of the directory /var/lib/cassandra.
     */
    private Long diskFreeKB;

    /*
     * Used memory (calculated as total - free - buffers - cache), in kB.
     */
    private Long memoryUsedKB;

    /*
     * Memory used by kernel buffers (Buffers in /proc/meminfo) and page cache and slabs (Cached and SReclaimable in
     * /proc/meminfo), in kB.
     */
    private Long memoryBuffersAndCachedKB;

    /*
     * Unused memory (MemFree and SwapFree in /proc/meminfo), in kB.
     */
    private Long memoryFreeKB;

    /*
     * Total installed memory (MemTotal and SwapTotal in /proc/meminfo), in kB.
     */
    private Long memoryTotalKB;

    /*
     * A float representing the current system-wide CPU utilization as a percentage.
     */
    private Double cpuUsage;

    /**
     * Creates an instance of CassandraClusterPublicStatusDataCentersItemNode class.
     */
    public CassandraClusterPublicStatusDataCentersItemNode() {
    }

    /**
     * Get the address property: The node's IP address.
     * 
     * @return the address value.
     */
    public String address() {
        return this.address;
    }

    /**
     * Set the address property: The node's IP address.
     * 
     * @param address the address value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get the state property: The state of the node in Cassandra ring.
     * 
     * @return the state value.
     */
    public NodeState state() {
        return this.state;
    }

    /**
     * Set the state property: The state of the node in Cassandra ring.
     * 
     * @param state the state value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withState(NodeState state) {
        this.state = state;
        return this;
    }

    /**
     * Get the status property: The status property.
     * 
     * @return the status value.
     */
    public String status() {
        return this.status;
    }

    /**
     * Set the status property: The status property.
     * 
     * @param status the status value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get the cassandraProcessStatus property: Cassandra service status on this node.
     * 
     * @return the cassandraProcessStatus value.
     */
    public String cassandraProcessStatus() {
        return this.cassandraProcessStatus;
    }

    /**
     * Set the cassandraProcessStatus property: Cassandra service status on this node.
     * 
     * @param cassandraProcessStatus the cassandraProcessStatus value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withCassandraProcessStatus(String cassandraProcessStatus) {
        this.cassandraProcessStatus = cassandraProcessStatus;
        return this;
    }

    /**
     * Get the load property: The amount of file system data in the data directory (e.g., 47.66 kB), excluding all
     * content in the snapshots subdirectories. Because all SSTable data files are included, any data that is not
     * cleaned up (such as TTL-expired cells or tombstones) is counted.
     * 
     * @return the load value.
     */
    public String load() {
        return this.load;
    }

    /**
     * Set the load property: The amount of file system data in the data directory (e.g., 47.66 kB), excluding all
     * content in the snapshots subdirectories. Because all SSTable data files are included, any data that is not
     * cleaned up (such as TTL-expired cells or tombstones) is counted.
     * 
     * @param load the load value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withLoad(String load) {
        this.load = load;
        return this;
    }

    /**
     * Get the tokens property: List of tokens this node covers.
     * 
     * @return the tokens value.
     */
    public List<String> tokens() {
        return this.tokens;
    }

    /**
     * Set the tokens property: List of tokens this node covers.
     * 
     * @param tokens the tokens value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withTokens(List<String> tokens) {
        this.tokens = tokens;
        return this;
    }

    /**
     * Get the size property: The size property.
     * 
     * @return the size value.
     */
    public Integer size() {
        return this.size;
    }

    /**
     * Set the size property: The size property.
     * 
     * @param size the size value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withSize(Integer size) {
        this.size = size;
        return this;
    }

    /**
     * Get the hostId property: The network ID of the node.
     * 
     * @return the hostId value.
     */
    public String hostId() {
        return this.hostId;
    }

    /**
     * Set the hostId property: The network ID of the node.
     * 
     * @param hostId the hostId value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withHostId(String hostId) {
        this.hostId = hostId;
        return this;
    }

    /**
     * Get the rack property: The rack this node is part of.
     * 
     * @return the rack value.
     */
    public String rack() {
        return this.rack;
    }

    /**
     * Set the rack property: The rack this node is part of.
     * 
     * @param rack the rack value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withRack(String rack) {
        this.rack = rack;
        return this;
    }

    /**
     * Get the timestamp property: The timestamp when these statistics were captured.
     * 
     * @return the timestamp value.
     */
    public String timestamp() {
        return this.timestamp;
    }

    /**
     * Set the timestamp property: The timestamp when these statistics were captured.
     * 
     * @param timestamp the timestamp value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get the diskUsedKB property: The amount of disk used, in kB, of the directory /var/lib/cassandra.
     * 
     * @return the diskUsedKB value.
     */
    public Long diskUsedKB() {
        return this.diskUsedKB;
    }

    /**
     * Set the diskUsedKB property: The amount of disk used, in kB, of the directory /var/lib/cassandra.
     * 
     * @param diskUsedKB the diskUsedKB value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withDiskUsedKB(Long diskUsedKB) {
        this.diskUsedKB = diskUsedKB;
        return this;
    }

    /**
     * Get the diskFreeKB property: The amount of disk free, in kB, of the directory /var/lib/cassandra.
     * 
     * @return the diskFreeKB value.
     */
    public Long diskFreeKB() {
        return this.diskFreeKB;
    }

    /**
     * Set the diskFreeKB property: The amount of disk free, in kB, of the directory /var/lib/cassandra.
     * 
     * @param diskFreeKB the diskFreeKB value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withDiskFreeKB(Long diskFreeKB) {
        this.diskFreeKB = diskFreeKB;
        return this;
    }

    /**
     * Get the memoryUsedKB property: Used memory (calculated as total - free - buffers - cache), in kB.
     * 
     * @return the memoryUsedKB value.
     */
    public Long memoryUsedKB() {
        return this.memoryUsedKB;
    }

    /**
     * Set the memoryUsedKB property: Used memory (calculated as total - free - buffers - cache), in kB.
     * 
     * @param memoryUsedKB the memoryUsedKB value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withMemoryUsedKB(Long memoryUsedKB) {
        this.memoryUsedKB = memoryUsedKB;
        return this;
    }

    /**
     * Get the memoryBuffersAndCachedKB property: Memory used by kernel buffers (Buffers in /proc/meminfo) and page
     * cache and slabs (Cached and SReclaimable in /proc/meminfo), in kB.
     * 
     * @return the memoryBuffersAndCachedKB value.
     */
    public Long memoryBuffersAndCachedKB() {
        return this.memoryBuffersAndCachedKB;
    }

    /**
     * Set the memoryBuffersAndCachedKB property: Memory used by kernel buffers (Buffers in /proc/meminfo) and page
     * cache and slabs (Cached and SReclaimable in /proc/meminfo), in kB.
     * 
     * @param memoryBuffersAndCachedKB the memoryBuffersAndCachedKB value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withMemoryBuffersAndCachedKB(Long memoryBuffersAndCachedKB) {
        this.memoryBuffersAndCachedKB = memoryBuffersAndCachedKB;
        return this;
    }

    /**
     * Get the memoryFreeKB property: Unused memory (MemFree and SwapFree in /proc/meminfo), in kB.
     * 
     * @return the memoryFreeKB value.
     */
    public Long memoryFreeKB() {
        return this.memoryFreeKB;
    }

    /**
     * Set the memoryFreeKB property: Unused memory (MemFree and SwapFree in /proc/meminfo), in kB.
     * 
     * @param memoryFreeKB the memoryFreeKB value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withMemoryFreeKB(Long memoryFreeKB) {
        this.memoryFreeKB = memoryFreeKB;
        return this;
    }

    /**
     * Get the memoryTotalKB property: Total installed memory (MemTotal and SwapTotal in /proc/meminfo), in kB.
     * 
     * @return the memoryTotalKB value.
     */
    public Long memoryTotalKB() {
        return this.memoryTotalKB;
    }

    /**
     * Set the memoryTotalKB property: Total installed memory (MemTotal and SwapTotal in /proc/meminfo), in kB.
     * 
     * @param memoryTotalKB the memoryTotalKB value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withMemoryTotalKB(Long memoryTotalKB) {
        this.memoryTotalKB = memoryTotalKB;
        return this;
    }

    /**
     * Get the cpuUsage property: A float representing the current system-wide CPU utilization as a percentage.
     * 
     * @return the cpuUsage value.
     */
    public Double cpuUsage() {
        return this.cpuUsage;
    }

    /**
     * Set the cpuUsage property: A float representing the current system-wide CPU utilization as a percentage.
     * 
     * @param cpuUsage the cpuUsage value to set.
     * @return the CassandraClusterPublicStatusDataCentersItemNode object itself.
     */
    public CassandraClusterPublicStatusDataCentersItemNode withCpuUsage(Double cpuUsage) {
        this.cpuUsage = cpuUsage;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("address", this.address);
        jsonWriter.writeStringField("state", this.state == null ? null : this.state.toString());
        jsonWriter.writeStringField("status", this.status);
        jsonWriter.writeStringField("cassandraProcessStatus", this.cassandraProcessStatus);
        jsonWriter.writeStringField("load", this.load);
        jsonWriter.writeArrayField("tokens", this.tokens, (writer, element) -> writer.writeString(element));
        jsonWriter.writeNumberField("size", this.size);
        jsonWriter.writeStringField("hostID", this.hostId);
        jsonWriter.writeStringField("rack", this.rack);
        jsonWriter.writeStringField("timestamp", this.timestamp);
        jsonWriter.writeNumberField("diskUsedKB", this.diskUsedKB);
        jsonWriter.writeNumberField("diskFreeKB", this.diskFreeKB);
        jsonWriter.writeNumberField("memoryUsedKB", this.memoryUsedKB);
        jsonWriter.writeNumberField("memoryBuffersAndCachedKB", this.memoryBuffersAndCachedKB);
        jsonWriter.writeNumberField("memoryFreeKB", this.memoryFreeKB);
        jsonWriter.writeNumberField("memoryTotalKB", this.memoryTotalKB);
        jsonWriter.writeNumberField("cpuUsage", this.cpuUsage);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CassandraClusterPublicStatusDataCentersItemNode from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CassandraClusterPublicStatusDataCentersItemNode if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the CassandraClusterPublicStatusDataCentersItemNode.
     */
    public static CassandraClusterPublicStatusDataCentersItemNode fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CassandraClusterPublicStatusDataCentersItemNode deserializedCassandraClusterPublicStatusDataCentersItemNode
                = new CassandraClusterPublicStatusDataCentersItemNode();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("address".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.address = reader.getString();
                } else if ("state".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.state
                        = NodeState.fromString(reader.getString());
                } else if ("status".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.status = reader.getString();
                } else if ("cassandraProcessStatus".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.cassandraProcessStatus
                        = reader.getString();
                } else if ("load".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.load = reader.getString();
                } else if ("tokens".equals(fieldName)) {
                    List<String> tokens = reader.readArray(reader1 -> reader1.getString());
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.tokens = tokens;
                } else if ("size".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.size
                        = reader.getNullable(JsonReader::getInt);
                } else if ("hostID".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.hostId = reader.getString();
                } else if ("rack".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.rack = reader.getString();
                } else if ("timestamp".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.timestamp = reader.getString();
                } else if ("diskUsedKB".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.diskUsedKB
                        = reader.getNullable(JsonReader::getLong);
                } else if ("diskFreeKB".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.diskFreeKB
                        = reader.getNullable(JsonReader::getLong);
                } else if ("memoryUsedKB".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.memoryUsedKB
                        = reader.getNullable(JsonReader::getLong);
                } else if ("memoryBuffersAndCachedKB".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.memoryBuffersAndCachedKB
                        = reader.getNullable(JsonReader::getLong);
                } else if ("memoryFreeKB".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.memoryFreeKB
                        = reader.getNullable(JsonReader::getLong);
                } else if ("memoryTotalKB".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.memoryTotalKB
                        = reader.getNullable(JsonReader::getLong);
                } else if ("cpuUsage".equals(fieldName)) {
                    deserializedCassandraClusterPublicStatusDataCentersItemNode.cpuUsage
                        = reader.getNullable(JsonReader::getDouble);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCassandraClusterPublicStatusDataCentersItemNode;
        });
    }
}
