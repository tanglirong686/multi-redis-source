package com.multiple.data.source.database.options;

import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class AbstractRoutingRedisTemplate<K, V> extends RedisTemplate<K, V> implements InitializingBean {

	/**
	 * 存放对应库的redisTemplate，用于操作对应的db
	 */
	private Map<Object, RedisTemplate<K, V>> redisTemplates;

	/**
	 * 当不指定库时默认使用的redisTemplate
	 */
	private RedisTemplate<K, V> defaultRedisTemplate;

	protected abstract Object determineCurrentLookupKey();

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

	/**
	 * 获取要操作的RedisTemplate
	 */
	protected RedisTemplate<K, V> determineTargetRedisTemplate() {
		// 当前要操作的DB
		Object lookupKey = determineCurrentLookupKey();
		// 如果当前要操作的DB为空则使用默认的RedisTemplate（使用0号库）
		if (lookupKey == null) {
			return defaultRedisTemplate;
		}
		RedisTemplate<K, V> redisTemplate = redisTemplates.get(lookupKey);
		// 如果当前要操作的db还没有维护到redisTemplates中，则创建一个对该库的连接并缓存起来
		if (redisTemplate == null) {
			redisTemplate = createRedisTemplateOnMissing(lookupKey);
			redisTemplates.put(lookupKey, redisTemplate);
		}
		return redisTemplate;
	}
}