package com.multiple.data.source.database.registrar;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * RedisProperties
 *  redis扩展配置
 */
@Data
@Configuration
@ConfigurationProperties(prefix = StoneRedisProperties.PREFIX)
public class StoneRedisProperties {

    public static final String PREFIX = "stone.redis";

    /**
     * 是否开启动态数据库切换 默认开启，如果关闭需要在yml中配置stone.redis.dynamic-database=false
     */
    private boolean dynamicDatabase = true;

    public boolean isDynamicDatabase() {
        return dynamicDatabase;
    }

    public boolean getDynamicDatabase() {
        return dynamicDatabase;
    }

}