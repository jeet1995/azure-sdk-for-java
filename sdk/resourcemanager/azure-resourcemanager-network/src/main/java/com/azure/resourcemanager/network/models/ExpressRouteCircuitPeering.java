// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.network.NetworkManager;
import com.azure.resourcemanager.network.fluent.models.ExpressRouteCircuitPeeringInner;
import com.azure.resourcemanager.resources.fluentcore.arm.models.IndependentChild;
import com.azure.resourcemanager.resources.fluentcore.model.Appliable;
import com.azure.resourcemanager.resources.fluentcore.model.Creatable;
import com.azure.resourcemanager.resources.fluentcore.model.HasInnerModel;
import com.azure.resourcemanager.resources.fluentcore.model.Refreshable;
import com.azure.resourcemanager.resources.fluentcore.model.Updatable;

/** Client-side representation of express route circuit peering object, associated with express route circuit. */
@Fluent
public interface ExpressRouteCircuitPeering
    extends IndependentChild<NetworkManager>, HasInnerModel<ExpressRouteCircuitPeeringInner>,
    Refreshable<ExpressRouteCircuitPeering>, Updatable<ExpressRouteCircuitPeering.Update> {

    // Getters

    /**
     * Gets peering type.
     *
     * @return peering type
     */
    ExpressRoutePeeringType peeringType();

    /**
     * Gets the state of peering.
     *
     * @return peering state
     */
    ExpressRoutePeeringState state();

    /**
     * Gets the Azure ASN.
     *
     * @return the Azure ASN
     */
    int azureAsn();

    /**
     * Gets the peer ASN.
     *
     * @return the peer ASN
     */
    long peerAsn();

    /**
     * Gets the primary address prefix.
     *
     * @return the primary address prefix
     */
    String primaryPeerAddressPrefix();

    /**
     * Gets the secondary address prefix.
     *
     * @return the secondary address prefix.
     */
    String secondaryPeerAddressPrefix();

    /**
     * Gets the primary port.
     *
     * @return the primary port
     */
    String primaryAzurePort();

    /**
     * Gets the secondary port.
     *
     * @return the secondary port
     */
    String secondaryAzurePort();

    /**
     * Gets the shared key.
     *
     * @return the shared key
     */
    String sharedKey();

    /**
     * GEts the VLAN ID.
     *
     * @return the VLAN ID
     */
    int vlanId();

    /**
     * Gets the Microsoft peering configuration.
     *
     * @return The Microsoft peering configuration.
     */
    ExpressRouteCircuitPeeringConfig microsoftPeeringConfig();

    /**
     * Gets peering stats.
     *
     * @return peering stats
     */
    ExpressRouteCircuitStats stats();

    /**
     * Gets the provisioning state of the resource.
     *
     * @return provisioningState
     */
    String provisioningState();

    /**
     * Gets the provider or the customer last modified the peering.
     *
     * @return whether the provider or the customer last modified the peering
     */
    String lastModifiedBy();

    /**
     * Gets the IPv6 peering configuration.
     *
     * @return the IPv6 peering configuration
     */
    Ipv6ExpressRouteCircuitPeeringConfig ipv6PeeringConfig();

    /** The entirety of the express route circuit peering definition. */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithAdvertisedPublicPrefixes,
        DefinitionStages.WithPrimaryPeerAddressPrefix, DefinitionStages.WithSecondaryPeerAddressPrefix,
        DefinitionStages.WithVlanId, DefinitionStages.WithPeerAsn, DefinitionStages.WithCreate {
    }

    /** Grouping of express route circuit peering definition stages. */
    interface DefinitionStages {
        /**
         * The first stage of an Express Route Circuit Peering configuration.
         */
        interface Blank extends WithPrimaryPeerAddressPrefix {
        }

        /** The stage of Express Route Circuit Peering definition allowing to specify advertised address prefixes. */
        interface WithAdvertisedPublicPrefixes {
            /**
             * Specify advertised prefixes: sets a list of all prefixes that are planned to advertise over the BGP
             * session. Only public IP address prefixes are accepted. A set of prefixes can be sent as a comma-separated
             * list. These prefixes must be registered to you in an RIR / IRR.
             *
             * @param publicPrefixes advertised prefixes
             * @return next stage of definition
             */
            WithPrimaryPeerAddressPrefix withAdvertisedPublicPrefixes(String publicPrefixes);
        }

        /** The stage of Express Route Circuit Peering definition allowing to specify primary address prefix. */
        interface WithPrimaryPeerAddressPrefix {
            /**
             * Specifies the primary peer address prefix for the Express Route Circuit Peering.
             *
             * @param addressPrefix the primary peer address prefix
             * @return next stage of definition
             */
            WithSecondaryPeerAddressPrefix withPrimaryPeerAddressPrefix(String addressPrefix);
        }

        /** The stage of Express Route Circuit Peering definition allowing to specify secondary address prefix. */
        interface WithSecondaryPeerAddressPrefix {
            /**
             * Specifies the secondary peer address prefix for the Express Route Circuit Peering.
             *
             * @param addressPrefix the secondary peer address prefix
             * @return next stage of definition
             */
            WithVlanId withSecondaryPeerAddressPrefix(String addressPrefix);
        }

        /** The stage of Express Route Circuit Peering definition allowing to specify VLAN ID. */
        interface WithVlanId {
            /**
             * Specifies a valid VLAN ID to establish this peering on.
             *
             * @param vlanId a valid VLAN ID to establish this peering on. No other peering in the circuit can use the
             *     same VLAN ID
             * @return next stage of definition
             */
            WithPeerAsn withVlanId(int vlanId);
        }

        /** The stage of Express Route Circuit Peering definition allowing to specify AS number for peering. */
        interface WithPeerAsn {
            /**
             * Specifies as number for peering
             *
             * @param peerAsn AS number for peering. Both 2-byte and 4-byte AS numbers can be used
             * @return next stage of definition
             */
            WithCreate withPeerAsn(long peerAsn);
        }

        /**
         * The stage of the Express Route Circuit Peering definition which contains all the minimum required inputs for
         * the resource to be created, but also allows for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<ExpressRouteCircuitPeering> {
        }
    }

    /** Grouping of express route circuit peering update stages. */
    interface Update extends Appliable<ExpressRouteCircuitPeering>, UpdateStages.WithAdvertisedPublicPrefixes,
        UpdateStages.WithPrimaryPeerAddressPrefix, UpdateStages.WithSecondaryPeerAddressPrefix, UpdateStages.WithVlanId,
        UpdateStages.WithPeerAsn {
    }

    /**
     * The template for express route circuit peering update operation, containing all the settings that can be
     * modified.
     */
    interface UpdateStages {
        /** The stage of Express Route Circuit Peering update allowing to specify advertised address prefixes. */
        interface WithAdvertisedPublicPrefixes {
            /**
             * Specifies the advertised public prefixes for the Express Route Circuit Peering.
             *
             * @param publicPrefixes the advertised public prefixes
             * @return next stage of update
             */
            Update withAdvertisedPublicPrefixes(String publicPrefixes);
        }

        /** The stage of Express Route Circuit Peering update allowing to specify primary address prefix. */
        interface WithPrimaryPeerAddressPrefix {
            /**
             * Specifies the primary peer address prefix for the Express Route Circuit Peering.
             *
             * @param addressPrefix the primary peer address prefix
             * @return next stage of update
             */
            Update withPrimaryPeerAddressPrefix(String addressPrefix);
        }

        /** The stage of Express Route Circuit Peering update allowing to specify secondary address prefix. */
        interface WithSecondaryPeerAddressPrefix {
            /**
             * Specifies the secondary peer address prefix for the Express Route Circuit Peering.
             *
             * @param addressPrefix the secondary peer address prefix
             * @return next stage of update
             */
            Update withSecondaryPeerAddressPrefix(String addressPrefix);
        }

        /** The stage of Express Route Circuit Peering update allowing to specify VLAN ID. */
        interface WithVlanId {
            /**
             * Specifies the VLAN ID for the Express Route Circuit Peering.
             *
             * @param vlanId the VLAN ID
             * @return next stage of update
             */
            Update withVlanId(int vlanId);
        }

        /** The stage of Express Route Circuit Peering update allowing to specify AS number for peering. */
        interface WithPeerAsn {
            /**
             * Specifies the peer AS number for the Express Route Circuit Peering.
             *
             * @param peerAsn the peer AS number
             * @return next stage of update
             */
            Update withPeerAsn(long peerAsn);
        }
    }
}
