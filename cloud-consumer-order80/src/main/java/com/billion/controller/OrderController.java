package com.billion.controller;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-04-22 18:43
 */
@RestController
@Slf4j
public class OrderController {
	private static final String INVOKE_URL = "http://CLOUD-PAYMENT-SERVICE";
	@Resource
	private RestTemplate restTemplate;

	@PostMapping("/order/create")
	public CommonResult create(Payment payment){
		return restTemplate.postForObject(INVOKE_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/order/get/{id}")
	public CommonResult getById(@PathVariable("id") Long id){
		return restTemplate.getForObject(INVOKE_URL + "/payment/get/" + id, CommonResult.class);
	}

	@GetMapping("/order/getEntity/{id}")
	public CommonResult getById2(@PathVariable("id") Long id){
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(INVOKE_URL + "/payment/get/" + id, CommonResult.class);
		log.info(entity.getStatusCodeValue() + "/t" + entity.getHeaders());
		if(entity.getStatusCode().is2xxSuccessful()){
			return entity.getBody();
		}else{
			return new CommonResult(404, "Not Found");
		}
	}
}
