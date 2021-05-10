package com.billion.springcloud.service;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Billion
 * @create 2021-04-28 10:46
 */
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {
	@PostMapping("/payment/create")
	CommonResult create(@RequestBody Payment payment);
	@GetMapping("/payment/get/{id}")
	CommonResult getById(@PathVariable("id") Long id);
}
