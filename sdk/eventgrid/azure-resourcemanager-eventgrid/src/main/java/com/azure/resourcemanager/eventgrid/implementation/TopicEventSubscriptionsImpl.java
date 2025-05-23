// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.eventgrid.fluent.TopicEventSubscriptionsClient;
import com.azure.resourcemanager.eventgrid.fluent.models.DeliveryAttributeListResultInner;
import com.azure.resourcemanager.eventgrid.fluent.models.EventSubscriptionFullUrlInner;
import com.azure.resourcemanager.eventgrid.fluent.models.EventSubscriptionInner;
import com.azure.resourcemanager.eventgrid.models.DeliveryAttributeListResult;
import com.azure.resourcemanager.eventgrid.models.EventSubscription;
import com.azure.resourcemanager.eventgrid.models.EventSubscriptionFullUrl;
import com.azure.resourcemanager.eventgrid.models.EventSubscriptionUpdateParameters;
import com.azure.resourcemanager.eventgrid.models.TopicEventSubscriptions;

public final class TopicEventSubscriptionsImpl implements TopicEventSubscriptions {
    private static final ClientLogger LOGGER = new ClientLogger(TopicEventSubscriptionsImpl.class);

    private final TopicEventSubscriptionsClient innerClient;

    private final com.azure.resourcemanager.eventgrid.EventGridManager serviceManager;

    public TopicEventSubscriptionsImpl(TopicEventSubscriptionsClient innerClient,
        com.azure.resourcemanager.eventgrid.EventGridManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<DeliveryAttributeListResult> getDeliveryAttributesWithResponse(String resourceGroupName,
        String topicName, String eventSubscriptionName, Context context) {
        Response<DeliveryAttributeListResultInner> inner = this.serviceClient()
            .getDeliveryAttributesWithResponse(resourceGroupName, topicName, eventSubscriptionName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new DeliveryAttributeListResultImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public DeliveryAttributeListResult getDeliveryAttributes(String resourceGroupName, String topicName,
        String eventSubscriptionName) {
        DeliveryAttributeListResultInner inner
            = this.serviceClient().getDeliveryAttributes(resourceGroupName, topicName, eventSubscriptionName);
        if (inner != null) {
            return new DeliveryAttributeListResultImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<EventSubscription> getWithResponse(String resourceGroupName, String topicName,
        String eventSubscriptionName, Context context) {
        Response<EventSubscriptionInner> inner
            = this.serviceClient().getWithResponse(resourceGroupName, topicName, eventSubscriptionName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new EventSubscriptionImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public EventSubscription get(String resourceGroupName, String topicName, String eventSubscriptionName) {
        EventSubscriptionInner inner = this.serviceClient().get(resourceGroupName, topicName, eventSubscriptionName);
        if (inner != null) {
            return new EventSubscriptionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public EventSubscription createOrUpdate(String resourceGroupName, String topicName, String eventSubscriptionName,
        EventSubscriptionInner eventSubscriptionInfo) {
        EventSubscriptionInner inner = this.serviceClient()
            .createOrUpdate(resourceGroupName, topicName, eventSubscriptionName, eventSubscriptionInfo);
        if (inner != null) {
            return new EventSubscriptionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public EventSubscription createOrUpdate(String resourceGroupName, String topicName, String eventSubscriptionName,
        EventSubscriptionInner eventSubscriptionInfo, Context context) {
        EventSubscriptionInner inner = this.serviceClient()
            .createOrUpdate(resourceGroupName, topicName, eventSubscriptionName, eventSubscriptionInfo, context);
        if (inner != null) {
            return new EventSubscriptionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String topicName, String eventSubscriptionName) {
        this.serviceClient().delete(resourceGroupName, topicName, eventSubscriptionName);
    }

    public void delete(String resourceGroupName, String topicName, String eventSubscriptionName, Context context) {
        this.serviceClient().delete(resourceGroupName, topicName, eventSubscriptionName, context);
    }

    public EventSubscription update(String resourceGroupName, String topicName, String eventSubscriptionName,
        EventSubscriptionUpdateParameters eventSubscriptionUpdateParameters) {
        EventSubscriptionInner inner = this.serviceClient()
            .update(resourceGroupName, topicName, eventSubscriptionName, eventSubscriptionUpdateParameters);
        if (inner != null) {
            return new EventSubscriptionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public EventSubscription update(String resourceGroupName, String topicName, String eventSubscriptionName,
        EventSubscriptionUpdateParameters eventSubscriptionUpdateParameters, Context context) {
        EventSubscriptionInner inner = this.serviceClient()
            .update(resourceGroupName, topicName, eventSubscriptionName, eventSubscriptionUpdateParameters, context);
        if (inner != null) {
            return new EventSubscriptionImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<EventSubscriptionFullUrl> getFullUrlWithResponse(String resourceGroupName, String topicName,
        String eventSubscriptionName, Context context) {
        Response<EventSubscriptionFullUrlInner> inner
            = this.serviceClient().getFullUrlWithResponse(resourceGroupName, topicName, eventSubscriptionName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new EventSubscriptionFullUrlImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public EventSubscriptionFullUrl getFullUrl(String resourceGroupName, String topicName,
        String eventSubscriptionName) {
        EventSubscriptionFullUrlInner inner
            = this.serviceClient().getFullUrl(resourceGroupName, topicName, eventSubscriptionName);
        if (inner != null) {
            return new EventSubscriptionFullUrlImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<EventSubscription> list(String resourceGroupName, String topicName) {
        PagedIterable<EventSubscriptionInner> inner = this.serviceClient().list(resourceGroupName, topicName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new EventSubscriptionImpl(inner1, this.manager()));
    }

    public PagedIterable<EventSubscription> list(String resourceGroupName, String topicName, String filter, Integer top,
        Context context) {
        PagedIterable<EventSubscriptionInner> inner
            = this.serviceClient().list(resourceGroupName, topicName, filter, top, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new EventSubscriptionImpl(inner1, this.manager()));
    }

    private TopicEventSubscriptionsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.eventgrid.EventGridManager manager() {
        return this.serviceManager;
    }
}
