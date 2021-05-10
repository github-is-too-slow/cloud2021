package com.billion.springcloud.controller;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Billion
 * @create 2021-05-06 13:33
 */
@RestController
public class BreakerController {
	@Value("${server.port}")
	private Integer serverPort;

	private static Map<Long, Payment> map = new HashMap<>();

	static {
		map.put(1L, new Payment(1L, "1234567890abc"));
		map.put(2L, new Payment(2L, "abc1234567890"));
		map.put(3L, new Payment(3L, "4567890abc6782kkd"));
	}

	@GetMapping("/get/{id}")
	public CommonResult getById(@PathVariable("id") Long id){
		return new CommonResult(200, "请求成功，port = " + serverPort, map.get(id));
	}
}
