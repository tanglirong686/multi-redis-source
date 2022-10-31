package com.multiple.data.source.database.options;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

public abstract class AbstractRoutingRedisTemplate<K, V> extends RedisTemplate<K, V> implements InitializingBean {

	/**
	 * 存放对应库的redisTemplate，用于操作对应的db
	 */
	private Map<Object, RedisTemplate<K, V>> redisTemplates;

	/**
	 * 当不指定库时默认使用的redisTemplate
	 */
	private RedisTemplate<K, V> defaultRedisTemplate;

	protected abstract RedisTemplate<K, V> createRedisTemplateOnMissing(Object lookupKey);

	public void setRedisTemplates(Map<Object, RedisTemplate<K, V>> redisTemplates) {
		this.redisTemplates = redisTemplates;
	}

	public void setDefaultRedisTemplate(RedisTemplate<K, V> defaultRedisTemplate) {
		this.defaultRedisTemplate = defaultRedisTemplate;
	}

	public Map<Object, RedisTemplate<K, V>> getRedisTemplates() {
		return redisTemplates;
	}

	public RedisTemplate<K, V> getDefaultRedisTemplate() {
		return defaultRedisTemplate;
	}
}