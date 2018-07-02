package com.orbitz.consul.config;

import com.google.common.base.Preconditions;

import java.time.Duration;

public class PoolConfig {
    private static final int DEFAULT_MAX_IDLE_CONNECTIONS = 5;
    private static final Duration DEFAULT_KEEP_ALIVE_DURATION = Duration.ofMinutes(5);

    private final int maxIdleConnections;
    private final Duration keepAliveDuration;

    private PoolConfig(int maxIdleConnections, Duration keepAliveDuration) {
        this.maxIdleConnections = maxIdleConnections;
        this.keepAliveDuration = keepAliveDuration;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public Duration getKeepAliveDuration() {
        return keepAliveDuration;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int maxIdleConnections = DEFAULT_MAX_IDLE_CONNECTIONS;
        private Duration keepAliveDuration = DEFAULT_KEEP_ALIVE_DURATION;

        private Builder() {
        }

        public Builder withMaxIdleConnections(final int maxIdleConnections) {
            Preconditions.checkArgument(maxIdleConnections > 0, "invalid maxIdleConnections value");
            this.maxIdleConnections = maxIdleConnections;
            return this;
        }

        public Builder withKeepAliveDuration(final Duration keepAliveDuration) {
            this.keepAliveDuration = Preconditions.checkNotNull(keepAliveDuration, "invalid keepAliveDuration value");
            return this;
        }

        public PoolConfig build() {
            return new PoolConfig(maxIdleConnections, keepAliveDuration);
        }
    }
}
