package com.xx.test.mt.common.cache.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisCacheManager implements IRedisCache{
	
	protected Log log = LogFactory.getLog(RedisCacheManager.class);
	
	private ShardedJedisPool pool;

	public void setPool(ShardedJedisPool pool) {
		this.pool = pool;
	}

	public <T> T getRedisCacheInfo(String key) {
		return null;
	}

	public <T> boolean setRedisCacheInfo(String key, T value) {
		return false;
	}

}
