package com.billion.springcloud.service.impl;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import com.billion.springcloud.service.FeignService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Billion
 * @create 2021-05-06 17:00
 */
@Service
public class FeignServiceImpl implements FeignService{
	@Override
	public CommonResult getById(Long id) {
		return new CommonResult(444, "openFeign服务降低处理", new Payment(id, "errorserial"));
	}
}
