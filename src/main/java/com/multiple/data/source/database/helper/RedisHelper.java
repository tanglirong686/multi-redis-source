package com.multiple.data.source.database.helper;

import com.multiple.data.source.database.options.AbstractOptionsRedisDb;
import com.multiple.data.source.database.options.DefaultOptionsRedisDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Assert;

import java.util.Map;

public class RedisHelper implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(RedisHelper.class);

	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";

	/**
	 * 使用连向默认的redis实例的redisTemplate
	 */
	private RedisTemplate<String, String> redisTemplate;

	/**
	 * 这里按RedisTemplate的设计模式设计，每一个RedisHelper一个AbstractOptionsRedisDb对象
	 */
	private AbstractOptionsRedisDb<String, String> optionsRedisDb = new DefaultOptionsRedisDb(this);

	public RedisHelper(RedisTemplate<String, String> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void afterPropertiesSet() {
		Assert.notNull(redisTemplate, "redisTemplate must not be null.");
	}

	/**
	 * 获取RedisTemplate对象
	 *
	 * @return RedisTemplate
	 */
	public RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}

	/**
	 * 设置当前线程操作 redis database，同一个线程内操作多次redis，不同database， 需要调用
	 * {@link RedisHelper#clearCurrentDatabase()} 清除当前线程redis database，从而使用默认的db.
	 * 如果静态RedisHelper进行db切换，这是不被允许的，需要抛出异常
	 *
	 * @param database redis database
	 */
	public void setCurrentDatabase(int database) {
		logger.warn("Use default RedisHelper, you'd better use a DynamicRedisHelper instead.");
		throw new RuntimeException("static redisHelper can't change db.");
	}

	/**
	 * 清除当前线程 redis database.
	 */
	public void clearCurrentDatabase() {
		logger.warn("Use default RedisHelper, you'd better use a DynamicRedisHelper instead.");
	}

	/**
	 * 获取RedisTemplates，静态RedisHelper中没有多个RedisTemplates，交给子类实现(这里适配其他功能)
	 */
	public Map<Object, RedisTemplate<String, String>> getRedisTemplates() {
		return null;
	}

	/**
	 * 操作redis db，获取操作对象
	 */
	public AbstractOptionsRedisDb<String, String> opsDb() {
		return optionsRedisDb;
	}

	/**
	 * 操作1号db
	 */
	public RedisTemplate<String, String> opsDbZero() {
		return optionsRedisDb.opsDbZero();
	}

	public RedisTemplate<String, String> opsDbOne() {
		return optionsRedisDb.opsDbOne();
	}

	public RedisTemplate<String, String> opsDbTwo() {
		return optionsRedisDb.opsDbTwo();
	}

	public RedisTemplate<String, String> opsDbThree() {
		return optionsRedisDb.opsDbThree();
	}

	public RedisTemplate<String, String> opsDbFour() {
		return optionsRedisDb.opsDbFour();
	}

	public RedisTemplate<String, String> opsDbFive() {
		return optionsRedisDb.opsDbFive();
	}

	public RedisTemplate<String, String> opsDbSix() {
		return optionsRedisDb.opsDbSix();
	}

	public RedisTemplate<String, String> opsDbSeven() {
		return optionsRedisDb.opsDbSeven();
	}

	public RedisTemplate<String, String> opsDbEight() {
		return optionsRedisDb.opsDbEight();
	}

	public RedisTemplate<String, String> opsDbNine() {
		return optionsRedisDb.opsDbNine();
	}

	public RedisTemplate<String, String> opsDbTen() {
		return optionsRedisDb.opsDbTen();
	}

	public RedisTemplate<String, String> opsDbEleven() {
		return optionsRedisDb.opsDbEleven();
	}

	public RedisTemplate<String, String> opsDbTwelve() {
		return optionsRedisDb.opsDbTwelve();
	}

	public RedisTemplate<String, String> opsDbThirteen() {
		return optionsRedisDb.opsDbThirteen();
	}

	public RedisTemplate<String, String> opsDbFourteen() {
		return optionsRedisDb.opsDbFourteen();
	}

	public RedisTemplate<String, String> opsDbFifteen() {
		return optionsRedisDb.opsDbFifteen();
	}

	public RedisTemplate<String, String> opsOtherDb(int db) {
		return optionsRedisDb.opsOtherDb(db);
	}
}
