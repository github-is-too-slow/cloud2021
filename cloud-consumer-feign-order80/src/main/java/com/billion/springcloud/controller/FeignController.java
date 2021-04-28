package com.billion.springcloud.controller;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import com.billion.springcloud.service.OpenFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-04-28 10:57
 */
@RestController
public class FeignController {
	@Resource
	private OpenFeignService openFeignService;

	@PostMapping("/order/create")
	public CommonResult create(@RequestBody Payment payment){
		return openFeignService.create(payment);
	}

	@GetMapping("/order/get/{id}")
	public CommonResult getById(@PathVariable("id") Long id){
		return openFeignService.getById(id);
	}
}
