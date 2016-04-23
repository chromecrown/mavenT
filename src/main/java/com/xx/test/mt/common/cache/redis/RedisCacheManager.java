package com.xx.test.mt.common.cache.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisCacheManager implements RedisCache{
	protected Log log = LogFactory.getLog(RedisCacheManager.class);
	
	private ShardedJedisPool pool;

	public void setPool(ShardedJedisPool pool) {
		this.pool = pool;
	}

	@SuppressWarnings("deprecation")
	public <T> T getRedisCacheInfo(String key) {
		try{
			log.info("get from redisCache:"+key);
			System.out.println("get from rediscache");
			ShardedJedis jedis = pool.getResource();
			pool.returnResource(jedis);
			return (T)jedis.get(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public <T> boolean setRedisCacheInfo(String key, T value) {
		try{
			log.info("add to redisCache:"+key);
			System.out.println("add to rediscache");
			ShardedJedis jedis = pool.getResource();
			jedis.set(key, (String)value);
			pool.returnResource(jedis);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}
