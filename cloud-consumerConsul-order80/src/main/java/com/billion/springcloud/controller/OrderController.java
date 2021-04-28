package com.billion.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-04-22 18:43
 */
@RestController
public class OrderController {
	private static final String INVOKE_URL = "http://cloud-provider-payment";
	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/order/consul")
	public String getPort(){
		return restTemplate.getForObject(INVOKE_URL + "//payment/consul", String.class);
	}
}
