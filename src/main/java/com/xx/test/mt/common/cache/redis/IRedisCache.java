package com.xx.test.mt.common.cache.redis;

public interface IRedisCache {
	
	public <T> T getRedisCacheInfo(String key);
	public <T> boolean setRedisCacheInfo(String key,T value);
}
