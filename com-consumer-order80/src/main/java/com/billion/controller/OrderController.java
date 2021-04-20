package com.billion.controller;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-04-19 21:58
 */
@RestController
public class OrderController {
	private static final String baseUrl = "http://localhost:8001";

	@Resource
	private RestTemplate restTemplate;

	@PostMapping("/consumer/create")
	public CommonResult create(Payment payment){
//		MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
//		params.add("serial", payment.getSerial());
		return restTemplate.postForObject(
				baseUrl + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/get/{id}")
	public CommonResult getById(@PathVariable("id") Long id){
		return restTemplate.getForObject(baseUrl + "/payment/get/" + id, CommonResult.class);
	}
}
