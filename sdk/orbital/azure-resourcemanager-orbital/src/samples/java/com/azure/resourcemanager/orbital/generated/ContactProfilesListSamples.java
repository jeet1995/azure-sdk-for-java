// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.orbital.generated;

/**
 * Samples for ContactProfiles List.
 */
public final class ContactProfilesListSamples {
    /*
     * x-ms-original-file: specification/orbital/resource-manager/Microsoft.Orbital/stable/2022-11-01/examples/
     * ContactProfilesBySubscriptionList.json
     */
    /**
     * Sample code: List of Contact Profiles.
     * 
     * @param manager Entry point to OrbitalManager.
     */
    public static void listOfContactProfiles(com.azure.resourcemanager.orbital.OrbitalManager manager) {
        manager.contactProfiles().list("opaqueString", com.azure.core.util.Context.NONE);
    }
}
