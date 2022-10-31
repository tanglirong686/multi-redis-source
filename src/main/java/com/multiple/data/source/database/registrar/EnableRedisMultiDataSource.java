package com.multiple.data.source.database.registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启Redis多数据源，由@EnableRedisMultiDataSource注解控制是否开启多数据源
 * 只有使用@EnableRedisMultiDataSource注解显示开启使用多数据源时才会注入相关的类
 * （比如：RedisMultiDataSourceRegistrar，RedisMultiSourceRegisterRunner）
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({RedisMultiDataSourceRegistrar.class})
public @interface EnableRedisMultiDataSource {

}