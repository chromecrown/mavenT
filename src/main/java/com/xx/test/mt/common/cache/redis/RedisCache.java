package com.xx.test.mt.common.cache.redis;

public interface RedisCache {
	public <T> T getRedisCacheInfo(String key);
	public <T> boolean setRedisCacheInfo(String key,T value);
}
