// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package io.clientcore.http.netty4.implementation;

import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.proxy.ProxyHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Utility class containing constants for Netty 4 handler names.
 * <p>
 * These names are used to find and properly position handlers in the Netty pipeline.
 */
public final class Netty4HandlerNames {

    /**
     * Name for the {@link ProxyHandler}.
     */
    public static final String PROXY = "clientcore.proxy";

    /**
     * Name for the proxy {@link HttpClientCodec}.
     */
    public static final String PROXY_CODEC = "clientcore.proxycodec";

    /**
     * Name for the {@link SslHandler}.
     */
    public static final String SSL = "clientcore.ssl";

    /**
     * Name for the {@link Netty4SslInitializationHandler}.
     */
    public static final String SSL_INITIALIZER = "clientcore.sslinitializer";

    /**
     * Name for the {@link Netty4AlpnHandler}.
     */
    public static final String ALPN = "clientcore.alpn";

    /**
     * Name for the HTTP/1.1 {@link HttpClientCodec}
     */
    public static final String HTTP_CODEC = "clientcore.httpcodec";

    /**
     * Name for the {@link Netty4ProgressAndTimeoutHandler}.
     */
    public static final String PROGRESS_AND_TIMEOUT = "clientcore.progressandtimeout";

    /**
     * Name for the {@link ChunkedWriteHandler}.
     */
    public static final String CHUNKED_WRITER = "clientcore.chunkedwriter";

    /**
     * Name for the {@link Netty4ResponseHandler}.
     */
    public static final String HTTP_RESPONSE = "clientcore.httpresponse";

    /**
     * Name for the {@link Netty4EagerConsumeChannelHandler}.
     */
    public static final String EAGER_CONSUME = "clientcore.eagerconsume";

    /**
     * Name for the {@link Netty4InitiateOneReadHandler}.
     */
    public static final String READ_ONE = "clientcore.readone";

    private Netty4HandlerNames() {
    }
}
