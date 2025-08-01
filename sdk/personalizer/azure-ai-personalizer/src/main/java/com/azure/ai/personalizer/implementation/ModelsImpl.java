// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.personalizer.implementation;

import com.azure.ai.personalizer.administration.models.PersonalizerModelProperties;
import com.azure.ai.personalizer.models.ErrorResponseException;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.Put;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import java.nio.ByteBuffer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in Models.
 */
public final class ModelsImpl {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ModelsService service;

    /**
     * The service client containing this operation class.
     */
    private final PersonalizerClientV1Preview3Impl client;

    /**
     * Initializes an instance of ModelsImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ModelsImpl(PersonalizerClientV1Preview3Impl client) {
        this.service = RestProxy.create(ModelsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for PersonalizerClientV1Preview3Models to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{Endpoint}/personalizer/{ApiVersion}")
    @ServiceInterface(name = "PersonalizerClientV1Preview3Models")
    public interface ModelsService {
        @Get("/model")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<BinaryData>> get(@HostParam("Endpoint") String endpoint,
            @HostParam("ApiVersion") String apiVersion, @QueryParam("signed") Boolean signed,
            @HeaderParam("Accept") String accept, Context context);

        @Put("/model")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<Void>> importMethod(@HostParam("Endpoint") String endpoint,
            @HostParam("ApiVersion") String apiVersion, @BodyParam("application/octet-stream") Flux<ByteBuffer> body,
            @HeaderParam("Content-Length") long contentLength, @HeaderParam("Accept") String accept, Context context);

        @Put("/model")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<Void>> importMethod(@HostParam("Endpoint") String endpoint,
            @HostParam("ApiVersion") String apiVersion, @BodyParam("application/octet-stream") BinaryData body,
            @HeaderParam("Content-Length") long contentLength, @HeaderParam("Accept") String accept, Context context);

        @Delete("/model")
        @ExpectedResponses({ 204 })
        @UnexpectedResponseExceptionType(ErrorResponseException.class)
        Mono<Response<Void>> reset(@HostParam("Endpoint") String endpoint, @HostParam("ApiVersion") String apiVersion,
            @HeaderParam("Accept") String accept, Context context);

        @Get("/model/properties")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(HttpResponseException.class)
        Mono<Response<PersonalizerModelProperties>> getProperties(@HostParam("Endpoint") String endpoint,
            @HostParam("ApiVersion") String apiVersion, @HeaderParam("Accept") String accept, Context context);
    }

    /**
     * Get Model.
     * 
     * Get the model file generated by Personalizer service.
     * 
     * @param signed True if requesting signed model zip archive, false otherwise.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the model file generated by Personalizer service along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> getWithResponseAsync(Boolean signed) {
        return FluxUtil.withContext(context -> getWithResponseAsync(signed, context));
    }

    /**
     * Get Model.
     * 
     * Get the model file generated by Personalizer service.
     * 
     * @param signed True if requesting signed model zip archive, false otherwise.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the model file generated by Personalizer service along with {@link Response} on successful completion of
     * {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<BinaryData>> getWithResponseAsync(Boolean signed, Context context) {
        final String accept = "application/octet-stream, application/json";
        return service.get(this.client.getEndpoint(), this.client.getApiVersion(), signed, accept, context);
    }

    /**
     * Get Model.
     * 
     * Get the model file generated by Personalizer service.
     * 
     * @param signed True if requesting signed model zip archive, false otherwise.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the model file generated by Personalizer service on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<BinaryData> getAsync(Boolean signed) {
        return getWithResponseAsync(signed).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get Model.
     * 
     * Get the model file generated by Personalizer service.
     * 
     * @param signed True if requesting signed model zip archive, false otherwise.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the model file generated by Personalizer service on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<BinaryData> getAsync(Boolean signed, Context context) {
        return getWithResponseAsync(signed, context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get Model.
     * 
     * Get the model file generated by Personalizer service.
     * 
     * @param signed True if requesting signed model zip archive, false otherwise.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the model file generated by Personalizer service along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BinaryData> getWithResponse(Boolean signed, Context context) {
        return getWithResponseAsync(signed, context).block();
    }

    /**
     * Get Model.
     * 
     * Get the model file generated by Personalizer service.
     * 
     * @param signed True if requesting signed model zip archive, false otherwise.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the model file generated by Personalizer service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BinaryData get(Boolean signed) {
        return getWithResponse(signed, Context.NONE).getValue();
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> importMethodWithResponseAsync(Flux<ByteBuffer> body, long contentLength) {
        return FluxUtil.withContext(context -> importMethodWithResponseAsync(body, contentLength, context));
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> importMethodWithResponseAsync(Flux<ByteBuffer> body, long contentLength,
        Context context) {
        final String accept = "application/json";
        return service.importMethod(this.client.getEndpoint(), this.client.getApiVersion(), body, contentLength, accept,
            context);
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> importMethodAsync(Flux<ByteBuffer> body, long contentLength) {
        return importMethodWithResponseAsync(body, contentLength).flatMap(ignored -> Mono.empty());
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> importMethodAsync(Flux<ByteBuffer> body, long contentLength, Context context) {
        return importMethodWithResponseAsync(body, contentLength, context).flatMap(ignored -> Mono.empty());
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> importMethodWithResponse(Flux<ByteBuffer> body, long contentLength, Context context) {
        return importMethodWithResponseAsync(body, contentLength, context).block();
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void importMethod(Flux<ByteBuffer> body, long contentLength) {
        importMethodWithResponse(body, contentLength, Context.NONE);
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> importMethodWithResponseAsync(BinaryData body, long contentLength) {
        return FluxUtil.withContext(context -> importMethodWithResponseAsync(body, contentLength, context));
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> importMethodWithResponseAsync(BinaryData body, long contentLength, Context context) {
        final String accept = "application/json";
        return service.importMethod(this.client.getEndpoint(), this.client.getApiVersion(), body, contentLength, accept,
            context);
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> importMethodAsync(BinaryData body, long contentLength) {
        return importMethodWithResponseAsync(body, contentLength).flatMap(ignored -> Mono.empty());
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> importMethodAsync(BinaryData body, long contentLength, Context context) {
        return importMethodWithResponseAsync(body, contentLength, context).flatMap(ignored -> Mono.empty());
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> importMethodWithResponse(BinaryData body, long contentLength, Context context) {
        return importMethodWithResponseAsync(body, contentLength, context).block();
    }

    /**
     * Put the digitally signed model file.
     * 
     * Replace the existing model file for the Personalizer service.
     * 
     * @param body The digitally signed model file obtained from getting the model.
     * @param contentLength The Content-Length header for the request.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void importMethod(BinaryData body, long contentLength) {
        importMethodWithResponse(body, contentLength, Context.NONE);
    }

    /**
     * Reset Model.
     * 
     * Resets the model file generated by Personalizer service.
     * 
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> resetWithResponseAsync() {
        return FluxUtil.withContext(context -> resetWithResponseAsync(context));
    }

    /**
     * Reset Model.
     * 
     * Resets the model file generated by Personalizer service.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> resetWithResponseAsync(Context context) {
        final String accept = "application/json";
        return service.reset(this.client.getEndpoint(), this.client.getApiVersion(), accept, context);
    }

    /**
     * Reset Model.
     * 
     * Resets the model file generated by Personalizer service.
     * 
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> resetAsync() {
        return resetWithResponseAsync().flatMap(ignored -> Mono.empty());
    }

    /**
     * Reset Model.
     * 
     * Resets the model file generated by Personalizer service.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> resetAsync(Context context) {
        return resetWithResponseAsync(context).flatMap(ignored -> Mono.empty());
    }

    /**
     * Reset Model.
     * 
     * Resets the model file generated by Personalizer service.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<Void> resetWithResponse(Context context) {
        return resetWithResponseAsync(context).block();
    }

    /**
     * Reset Model.
     * 
     * Resets the model file generated by Personalizer service.
     * 
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public void reset() {
        resetWithResponse(Context.NONE);
    }

    /**
     * Get Model Properties.
     * 
     * Get properties of the model file generated by Personalizer service.
     * 
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the model file generated by Personalizer service along with {@link Response} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<PersonalizerModelProperties>> getPropertiesWithResponseAsync() {
        return FluxUtil.withContext(context -> getPropertiesWithResponseAsync(context));
    }

    /**
     * Get Model Properties.
     * 
     * Get properties of the model file generated by Personalizer service.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the model file generated by Personalizer service along with {@link Response} on successful
     * completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<PersonalizerModelProperties>> getPropertiesWithResponseAsync(Context context) {
        final String accept = "application/json";
        return service.getProperties(this.client.getEndpoint(), this.client.getApiVersion(), accept, context);
    }

    /**
     * Get Model Properties.
     * 
     * Get properties of the model file generated by Personalizer service.
     * 
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the model file generated by Personalizer service on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PersonalizerModelProperties> getPropertiesAsync() {
        return getPropertiesWithResponseAsync().flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get Model Properties.
     * 
     * Get properties of the model file generated by Personalizer service.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the model file generated by Personalizer service on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<PersonalizerModelProperties> getPropertiesAsync(Context context) {
        return getPropertiesWithResponseAsync(context).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Get Model Properties.
     * 
     * Get properties of the model file generated by Personalizer service.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the model file generated by Personalizer service along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<PersonalizerModelProperties> getPropertiesWithResponse(Context context) {
        return getPropertiesWithResponseAsync(context).block();
    }

    /**
     * Get Model Properties.
     * 
     * Get properties of the model file generated by Personalizer service.
     * 
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the model file generated by Personalizer service.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public PersonalizerModelProperties getProperties() {
        return getPropertiesWithResponse(Context.NONE).getValue();
    }
}
