package com.multiple.data.source.constant;

/**
 * data-redis增强模块常用常量
 */
public interface EnhanceRedisConstants {

    /**
     * 多数据源相关常量
     */
    interface MultiSource {

        String REDIS_TEMPLATE = "RedisTemplate";

        String REDIS_HELPER = "RedisHelper";

        String DEFAULT_SOURCE = "defaultSource";

        String DEFAULT_SOURCE_HELPER = "defaultSourceRedisHelper";

        String DEFAULT_SOURCE_TEMPLATE = "defaultSourceRedisTemplate";
    }

    /**
     * 默认redis数据源的redisHelper注入名称
     */
    interface DefaultRedisHelperName {

        String REDIS_HELPER = "redisHelper";

        String DEFAULT = "default";

        String DEFAULT_REDIS_HELPER = "default-helper";
    }

    /**
     * 默认redis数据源的redisHelper注入名称
     */
    interface DefaultRedisTemplateName {

        String REDIS_TEMPLATE = "redisTemplate";

    }
}