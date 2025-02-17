// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.directconnectivity.rntbd;

import com.azure.cosmos.implementation.ConnectionPolicy;
import com.azure.cosmos.implementation.clienttelemetry.ClientTelemetry;
import com.azure.cosmos.implementation.clienttelemetry.ClientTelemetryInfo;
import com.azure.cosmos.implementation.cpu.CpuLoadHistory;
import com.azure.cosmos.implementation.cpu.CpuMemoryMonitor;
import com.azure.cosmos.implementation.directconnectivity.RntbdTransportClient;
import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.ssl.SslContext;
import io.netty.util.concurrent.Future;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class RntbdClientChannelHealthCheckerTests {
    private static final long writeHangGracePeriodInNanos = 2L * 1_000_000_000L;
    private static final long readHangGracePeriodInNanos = (45L + 10L) * 1_000_000_000L;
    private static final long recentReadWindowInNanos = 1_000_000_000L;

    @DataProvider
    public static Object[][] isHealthyWithReasonArgs() {
        return new Object[][]{
                // expect failureReason
                { false },
                { true }
        };
    }

    @Test(groups = { "unit" },  dataProvider = "isHealthyWithReasonArgs")
    public void isHealthyForWriteHangTests(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
                new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
                sslContextMock,
                LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);

        Instant currentTime = Instant.now();
        Instant lastChannelWriteAttemptTime = Instant.now().minusNanos(writeHangGracePeriodInNanos).minusNanos(10);
        Instant lastChannelWriteTime = lastChannelWriteAttemptTime.minusNanos(config.sendHangDetectionTimeInNanos()).minusNanos(10);
        Instant lastChannelReadTime = currentTime.minusNanos(recentReadWindowInNanos).minusNanos(10);

        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteAttemptTime);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);

        if (withFailureReason) {
            Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();
            assertThat(healthyResult.getNow()).isNotEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
            assertThat(healthyResult.getNow().contains("health check failed due to non-responding write")).isTrue();
            assertThat(healthyResult.getNow().contains("clientVmId: testClientVmId")).isTrue();
        } else {
            Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();
            assertThat(healthyResult.getNow()).isFalse();
        }
    }

    @Test(groups = { "unit" }, dataProvider = "isHealthyWithReasonArgs")
    public void isHealthyForReadHangTests(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
                new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
                sslContextMock,
                LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);

        Instant lastChannelWriteTime = Instant.now().minusNanos(readHangGracePeriodInNanos).minusNanos(10);
        Instant lastChannelWriteAttemptTime = lastChannelWriteTime;
        Instant lastChannelReadTime = lastChannelWriteTime.minusNanos(config.receiveHangDetectionTimeInNanos()).minusNanos(10);

        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteAttemptTime);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);

        if (withFailureReason) {
            Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();

            String message = healthyResult.getNow();
            assertThat(message).isNotEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
            assertThat(message.contains("health check failed due to non-responding read")).isTrue();
            assertThat(message.contains("clientVmId: testClientVmId")).isTrue();
            validateSystemDiagnostics(message);
        } else {
            Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();
            assertThat(healthyResult.getNow()).isFalse();
        }
    }

    @Test(groups = { "unit" }, dataProvider = "isHealthyWithReasonArgs")
    public void transitTimeoutTimeLimitTests(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
                new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
                sslContextMock,
                LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);

        Instant current = Instant.now();
        Instant lastChannelReadTime = current.minusNanos(config.timeoutDetectionTimeLimitInNanos()).minusNanos(10);
        Instant lastChannelWriteTime = lastChannelReadTime.plusSeconds(1);
        Instant lastChannelWriteAttemptTime = lastChannelWriteTime;

        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);
        Mockito.when(timestampsMock.transitTimeoutCount()).thenReturn(1);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteAttemptTime);

        if (withFailureReason) {
            Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();
            assertThat(healthyResult.getNow()).isNotEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
            assertThat(healthyResult.getNow().contains("health check failed due to transit timeout detection time limit"));
        } else {
            Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();
            assertThat(healthyResult.getNow()).isFalse();
        }
    }

    @Test(groups = { "unit" }, dataProvider = "isHealthyWithReasonArgs")
    public void transitTimeoutHighFrequencyTests(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
            new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
            sslContextMock,
            LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);

        Instant current = Instant.now();
        Instant lastChannelReadTime = current.minusNanos(config.timeoutDetectionHighFrequencyTimeLimitInNanos()).minusNanos(10);
        Instant lastChannelWriteTime = lastChannelReadTime.plusSeconds(1);
        Instant lastChannelWriteAttemptTime = lastChannelWriteTime;
        int timeoutCount = config.timeoutDetectionHighFrequencyThreshold() + 1;

        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);
        Mockito.when(timestampsMock.transitTimeoutCount()).thenReturn(timeoutCount);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteAttemptTime);

        if (withFailureReason) {
            Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();

            String message = healthyResult.getNow();
            assertThat(message).isNotEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
            assertThat(message.contains("health check failed due to transit timeout high frequency threshold hit")).isTrue();
            assertThat(message.contains("clientVmId: testClientVmId")).isTrue();
            validateSystemDiagnostics(message);
        } else {
            Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();
            assertThat(healthyResult.getNow()).isFalse();
        }
    }

    @Test(groups = { "unit" }, dataProvider = "isHealthyWithReasonArgs")
    public void transitTimeoutOnWriteTests(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
            new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
            sslContextMock,
            LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);

        Instant current = Instant.now();
        Instant lastChannelReadTime = current.minusNanos(config.timeoutDetectionOnWriteTimeLimitInNanos()).minusNanos(10);
        Instant lastChannelWriteTime = lastChannelReadTime.plusSeconds(1);
        Instant lastChannelWriteAttemptTime = lastChannelWriteTime;
        int writeTimeoutCount = config.timeoutDetectionOnWriteThreshold() + 1;

        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);
        Mockito.when(timestampsMock.transitTimeoutCount()).thenReturn(writeTimeoutCount);
        Mockito.when(timestampsMock.tansitTimeoutWriteCount()).thenReturn(writeTimeoutCount);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteAttemptTime);

        if (withFailureReason) {
            Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();

            String message = healthyResult.getNow();
            assertThat(message).isNotEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
            assertThat(message).contains("health check failed due to transit timeout on write threshold hit");
            assertThat(message).contains("clientVmId: testClientVmId");
            validateSystemDiagnostics(message);
        } else {
            Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
            assertThat(healthyResult.isSuccess()).isTrue();
            assertThat(healthyResult.getNow()).isFalse();
        }
    }


    @Test(groups = { "unit" }, dataProvider = "isHealthyWithReasonArgs")
    public void transitTimeoutOnWrite_HighCPULoadTests(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
            new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
            sslContextMock,
            LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);
        ChannelPromise defaultChannelPromise = new DefaultChannelPromise(channelMock);
        defaultChannelPromise.setSuccess();
        Mockito.when(channelMock.writeAndFlush(RntbdHealthCheckRequest.MESSAGE)).thenReturn(defaultChannelPromise);

        Instant current = Instant.now();
        Instant lastChannelReadTime = current.minusNanos(config.timeoutDetectionOnWriteTimeLimitInNanos()).minusNanos(10);
        Instant lastChannelWriteTime = lastChannelReadTime.plusSeconds(1);
        Instant lastChannelWriteAttemptTime = lastChannelWriteTime;
        int writeTimeoutCount = config.timeoutDetectionOnWriteThreshold() + 1;

        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);
        Mockito.when(timestampsMock.transitTimeoutCount()).thenReturn(writeTimeoutCount);
        Mockito.when(timestampsMock.tansitTimeoutWriteCount()).thenReturn(writeTimeoutCount);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteAttemptTime);
        Mockito.doNothing().when(timestampsMock).resetTransitTimeout();

        try(MockedStatic<CpuMemoryMonitor> cpuMemoryMonitorMock = Mockito.mockStatic(CpuMemoryMonitor.class)) {
            CpuLoadHistory cpuLoadHistoryMock = Mockito.mock(CpuLoadHistory.class);
            cpuMemoryMonitorMock.when(CpuMemoryMonitor::getCpuLoad).thenReturn(cpuLoadHistoryMock);
            Mockito.when(cpuLoadHistoryMock.isCpuOverThreshold(config.timeoutDetectionDisableCPUThreshold())).thenReturn(true);

            if (withFailureReason) {
                Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
                assertThat(healthyResult.isSuccess()).isTrue();
                assertThat(healthyResult.getNow()).isEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
                // Verify under high CPU load, the transitTimeout will be reset
                Mockito.verify(timestampsMock, Mockito.times(1)).resetTransitTimeout();

            } else {
                Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
                assertThat(healthyResult.isSuccess()).isTrue();
                assertThat(healthyResult.getNow()).isTrue();
                // Verify under high CPU load, the transitTimeout will be reset
                Mockito.verify(timestampsMock, Mockito.times(1)).resetTransitTimeout();
            }
        }
    }

    @Test(groups = { "unit" },  dataProvider = "isHealthyWithReasonArgs")
    public void cancellationPronenessOfChannel_Test(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
            new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
            sslContextMock,
            LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);
        ChannelPromise defaultChannelPromise = new DefaultChannelPromise(channelMock);
        defaultChannelPromise.setSuccess();
        Mockito.when(channelMock.writeAndFlush(RntbdHealthCheckRequest.MESSAGE)).thenReturn(defaultChannelPromise);

        Instant current = Instant.now();
        Instant lastChannelReadTime = current.minusNanos(5 * config.nonRespondingChannelReadDelayTimeLimitInNanos());
        Instant lastChannelWriteTime = current.plusSeconds(1);
        Instant lastChannelWriteAttemptTime = lastChannelWriteTime;

        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteAttemptTime);
        Mockito.when(timestampsMock.transitTimeoutCount()).thenReturn(0);
        Mockito.when(timestampsMock.cancellationCount()).thenReturn(config.cancellationCountSinceLastReadThreshold());

        try(MockedStatic<CpuMemoryMonitor> cpuMemoryMonitorMock = Mockito.mockStatic(CpuMemoryMonitor.class)) {
            CpuLoadHistory cpuLoadHistoryMock = Mockito.mock(CpuLoadHistory.class);
            cpuMemoryMonitorMock.when(CpuMemoryMonitor::getCpuLoad).thenReturn(cpuLoadHistoryMock);
            Mockito.when(cpuLoadHistoryMock.isCpuOverThreshold(config.timeoutDetectionDisableCPUThreshold())).thenReturn(false);

            if (withFailureReason) {
                Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
                assertThat(healthyResult.isSuccess()).isTrue();
                assertThat(healthyResult.getNow()).isNotEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
                assertThat(healthyResult.getNow()).contains("health check failed due to channel being cancellation prone");
            } else {
                Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
                assertThat(healthyResult.isSuccess()).isTrue();
                assertThat(healthyResult.getNow()).isFalse();
            }
        }
    }

    @Test(groups = { "unit" },  dataProvider = "isHealthyWithReasonArgs")
    public void cancellationPronenessOfChannelWithHighCpuLoad_Test(boolean withFailureReason) throws InterruptedException {
        SslContext sslContextMock = Mockito.mock(SslContext.class);

        RntbdEndpoint.Config config = new RntbdEndpoint.Config(
            new RntbdTransportClient.Options.Builder(ConnectionPolicy.getDefaultPolicy()).build(),
            sslContextMock,
            LogLevel.INFO);

        ClientTelemetry clientTelemetryMock = Mockito.mock(ClientTelemetry.class);
        ClientTelemetryInfo clientTelemetryInfoMock = Mockito.mock(ClientTelemetryInfo.class);
        Mockito.when(clientTelemetryMock.getClientTelemetryInfo()).thenReturn(clientTelemetryInfoMock);
        Mockito.when(clientTelemetryInfoMock.getMachineId()).thenReturn("testClientVmId");

        RntbdClientChannelHealthChecker healthChecker = new RntbdClientChannelHealthChecker(config, clientTelemetryMock);
        Channel channelMock = Mockito.mock(Channel.class);
        ChannelPipeline channelPipelineMock = Mockito.mock(ChannelPipeline.class);
        RntbdRequestManager rntbdRequestManagerMock = Mockito.mock(RntbdRequestManager.class);
        SingleThreadEventLoop eventLoopMock = new DefaultEventLoop();
        RntbdClientChannelHealthChecker.Timestamps timestampsMock = Mockito.mock(RntbdClientChannelHealthChecker.Timestamps.class);

        Mockito.when(channelMock.pipeline()).thenReturn(channelPipelineMock);
        Mockito.when(channelPipelineMock.get(RntbdRequestManager.class)).thenReturn(rntbdRequestManagerMock);
        Mockito.when(channelMock.eventLoop()).thenReturn(eventLoopMock);
        Mockito.when(rntbdRequestManagerMock.snapshotTimestamps()).thenReturn(timestampsMock);
        ChannelPromise defaultChannelPromise = new DefaultChannelPromise(channelMock);
        defaultChannelPromise.setSuccess();
        Mockito.when(channelMock.writeAndFlush(RntbdHealthCheckRequest.MESSAGE)).thenReturn(defaultChannelPromise);

        Instant current = Instant.now();
        Instant lastChannelReadTime = current.minusNanos(config.nonRespondingChannelReadDelayTimeLimitInNanos());
        Instant lastChannelWriteTime = current.plusSeconds(1);

        Mockito.when(timestampsMock.lastChannelReadTime()).thenReturn(lastChannelReadTime);
        Mockito.when(timestampsMock.lastChannelWriteTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.lastChannelWriteAttemptTime()).thenReturn(lastChannelWriteTime);
        Mockito.when(timestampsMock.transitTimeoutCount()).thenReturn(0);
        Mockito.when(timestampsMock.cancellationCount()).thenReturn(config.cancellationCountSinceLastReadThreshold());
        Mockito.doNothing().when(timestampsMock).resetCancellationCount();

        try(MockedStatic<CpuMemoryMonitor> cpuMemoryMonitorMock = Mockito.mockStatic(CpuMemoryMonitor.class)) {
            CpuLoadHistory cpuLoadHistoryMock = Mockito.mock(CpuLoadHistory.class);
            cpuMemoryMonitorMock.when(CpuMemoryMonitor::getCpuLoad).thenReturn(cpuLoadHistoryMock);
            Mockito.when(cpuLoadHistoryMock.isCpuOverThreshold(config.timeoutDetectionDisableCPUThreshold())).thenReturn(true);

            if (withFailureReason) {
                Future<String> healthyResult = healthChecker.isHealthyWithFailureReason(channelMock).sync();
                assertThat(healthyResult.isSuccess()).isTrue();
                String message = healthyResult.getNow();
                assertThat(message).isEqualTo(RntbdConstants.RntbdHealthCheckResults.SuccessValue);
                // Verify under high CPU load, the cancellationCount will be reset
                Mockito.verify(timestampsMock, Mockito.times(1)).resetCancellationCount();
            } else {
                Future<Boolean> healthyResult = healthChecker.isHealthy(channelMock).sync();
                assertThat(healthyResult.isSuccess()).isTrue();
                assertThat(healthyResult.getNow()).isTrue();
                // Verify under high CPU load, the transitTimeout will be reset
                Mockito.verify(timestampsMock, Mockito.times(1)).resetCancellationCount();
            }
        }
    }

    private void validateSystemDiagnostics(String string) {
        assertThat(string.contains("clientUsedMemory")).isTrue();
        assertThat(string.contains("clientAvailableMemory")).isTrue();
        assertThat(string.contains("clientSystemCpuLoad")).isTrue();
        assertThat(string.contains("clientAvailableProcessors")).isTrue();
    }
}
