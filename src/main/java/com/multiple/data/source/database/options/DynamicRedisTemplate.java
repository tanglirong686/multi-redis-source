package com.multiple.data.source.database.options;

import com.multiple.data.source.database.config.DynamicRedisTemplateFactory;
import com.multiple.data.source.database.helper.RedisDatabaseThreadLocalHelper;
import org.springframework.data.redis.core.RedisTemplate;

public class DynamicRedisTemplate<K, V> extends AbstractRoutingRedisTemplate<K, V> {
	
	/**
     * 动态RedisTemplate工厂，用于创建管理动态DynamicRedisTemplate
     */
    private final DynamicRedisTemplateFactory<K, V> dynamicRedisTemplateFactory;

    public DynamicRedisTemplate(DynamicRedisTemplateFactory<K, V> dynamicRedisTemplateFactory) {
        this.dynamicRedisTemplateFactory = dynamicRedisTemplateFactory;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return RedisDatabaseThreadLocalHelper.get();
    }

    /**
	 * 通过制定的db创建RedisTemplate
	 *
	 * @param lookupKey db号
	 * @return org.springframework.data.redis.core.RedisTemplate<K, V>
	 */
    @Override
    public RedisTemplate<K, V> createRedisTemplateOnMissing(Object lookupKey) {
        return dynamicRedisTemplateFactory.createRedisTemplate((Integer) lookupKey);
    }
}