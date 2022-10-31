package com.multiple.data.source.service.impl;

import com.multiple.data.source.database.helper.RedisHelper;
import com.multiple.data.source.database.helper.RedisOperationHelper;
import com.multiple.data.source.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private RedisHelper redisHelper;

	@Autowired
	private RedisTemplate<String ,String> redisTemplate;

	@Override
	@PostConstruct
	public void test() {
		RedisTemplate<String, String> dbTwo = redisHelper.opsDbTwo();
		RedisOperationHelper helper2 = new RedisOperationHelper(dbTwo);
		helper2.strSet("hello", "world" , 60 , TimeUnit.SECONDS);

		Map<String , String> map = new HashMap<>();
		map.put("name","marry");
		map.put("age","22");
		RedisTemplate<String, String> dbThree = redisHelper.opsDbThree();
		RedisOperationHelper helper3 = new RedisOperationHelper(dbThree);
		helper3.hashPutAll("world" , map);
		dbThree.expire("world" , 60 , TimeUnit.SECONDS);

		RedisTemplate<String, String> dbFour = redisHelper.opsDbFour();
		RedisOperationHelper helper4 = new RedisOperationHelper(dbFour);
		helper4.strSet("go","run" ,60 , TimeUnit.SECONDS);
	}

	public void test1(){
		Map<String , String> map = new HashMap<>();
		map.put("name","marry");
		map.put("age","22");
		redisTemplate.opsForHash().putAll("hello", map);
	}
}