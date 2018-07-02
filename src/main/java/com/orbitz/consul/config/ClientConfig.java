package com.orbitz.consul.config;

import com.google.common.base.Preconditions;

public class ClientConfig {
    private static final CacheConfig DEFAULT_CACHE_CONFIG = CacheConfig.builder().build();
    private static final PoolConfig DEFAULT_POOL_CONFIG = PoolConfig.builder().build();

    private final CacheConfig cacheConfig;
    private final PoolConfig poolConfig;

    public ClientConfig() {
        this(DEFAULT_CACHE_CONFIG, DEFAULT_POOL_CONFIG);
    }

    public ClientConfig(CacheConfig cacheConfig) {
        this(cacheConfig, DEFAULT_POOL_CONFIG);
    }

    public ClientConfig(CacheConfig cacheConfig, PoolConfig poolConfig) {
        this.cacheConfig = Preconditions.checkNotNull(cacheConfig, "Cache configuration is mandatory");
        this.poolConfig = Preconditions.checkNotNull(poolConfig, "Pool configuration is mandatory");
    }

    public CacheConfig getCacheConfig() {
        return cacheConfig;
    }

    public PoolConfig getPoolConfig() {
        return poolConfig;
    }

    public static class Builder {

    }
}
