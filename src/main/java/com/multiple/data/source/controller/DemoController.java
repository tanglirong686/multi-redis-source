package com.multiple.data.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiple.data.source.service.DemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/demo")
@Api(value = "示例", tags = "示例demo")
public class DemoController {

	@Autowired
    private DemoService demoService;
	
	/**
	 * 	测试多数据源分库查询
	 * @throws Exception
	 */
	@GetMapping("testMultipleQuery")
	@ApiOperation("测试多数据源")
	void testMultipleQuery() throws Exception {
		demoService.test();
	}
}