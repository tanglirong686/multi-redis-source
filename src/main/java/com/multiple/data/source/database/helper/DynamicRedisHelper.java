package com.multiple.data.source.database.helper;

import com.multiple.data.source.database.options.DynamicRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

/**
 * Redis操作工具类，集成封装一些常用方法，支持动态切换DB
 *
 */
public class DynamicRedisHelper extends RedisHelper {

    /**
     * 动态redisTemplate
     */
    private final DynamicRedisTemplate<String, String> redisTemplate;

    public DynamicRedisHelper(DynamicRedisTemplate<String, String> redisTemplate) {
        super(redisTemplate);
        this.redisTemplate = redisTemplate;
    }

    /**
     * <p>
     * 获取RedisTemplate对象
     * </p>
     * redisTemplate
     */
    @Override
    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    /**
     * 获取该redis数据源对应的多个RedisTemplate
     */
    @Override
    public Map<Object, RedisTemplate<String, String>> getRedisTemplates() {
        return redisTemplate.getRedisTemplates();
    }
}