package com.billion.controller;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import com.billion.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-04-19 20:40
 */
@RestController
@Slf4j
public class PaymentController {
	@Resource
	private PaymentService paymentService;

	@PostMapping("/payment/create")
	public CommonResult create(@RequestBody Payment payment){
		System.out.println(payment);
		int result = paymentService.create(payment);
		log.info("插入结果：" + result);
		if(result > 0){
			return new CommonResult<>(200, "创建订单成功", result);
		}else {
			return new CommonResult<>(444, "创建订单失败", result);
		}
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult getById(@PathVariable("id") Long id){
		Payment result = paymentService.getById(id);
		log.info("查询结果：" + result);
		if(result != null){
			return new CommonResult<>(200, "查询成功", result);
		}else {
			return new CommonResult<>(444, "查询失败，无对应订单编号：" + id, result);
		}
	}
}
