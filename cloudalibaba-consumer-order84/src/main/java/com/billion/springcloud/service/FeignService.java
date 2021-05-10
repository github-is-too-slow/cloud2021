package com.billion.springcloud.service;

import com.billion.entity.CommonResult;
import com.billion.springcloud.service.impl.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Billion
 * @create 2021-05-06 16:56
 */
@FeignClient(value = "cloudalibaba-payment-service", fallback = FeignServiceImpl.class)
public interface FeignService {
	@GetMapping("/get/{id}")
	CommonResult getById(@PathVariable("id") Long id);
}
