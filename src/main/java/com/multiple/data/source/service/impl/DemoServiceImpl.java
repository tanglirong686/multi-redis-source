package com.multiple.data.source.service.impl;

import javax.annotation.PostConstruct;

import com.multiple.data.source.database.config.DynamicRedisTemplateFactory;
import com.multiple.data.source.database.helper.DynamicRedisHelper;
import com.multiple.data.source.database.helper.RedisHelper;
import com.multiple.data.source.database.options.DynamicRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.multiple.data.source.service.DemoService;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private RedisHelper db1RedisHelper;

	@Override
	@PostConstruct
	public void test() {
		db1RedisHelper.opsDbTwo().opsForValue().set("hello", "world");

		Map<String , Object> map = new HashMap<>();
		map.put("name","marry");
		map.put("age","22");
		db1RedisHelper.opsDbThree().opsForHash().putAll("world" , map);

		db1RedisHelper.opsDbFour().opsForValue().set("go","run");
	}
}