package com.billion.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-04 16:54
 */
@RestController
public class OrderController {
	@Value("${service-url.nacos-user-service}")
	private String baseUrl;

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/payment/nacos/{id}")
	public String getInfo(@PathVariable("id") Integer id){
		return restTemplate.getForObject(baseUrl + "/payment/nacos/" + id, String.class);
	}
}
