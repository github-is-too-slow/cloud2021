package com.billion.springcloud.controller;

import com.billion.entity.CommonResult;
import com.billion.springcloud.domain.Order;
import com.billion.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-07 17:05
 */
@RestController
public class OrderController {
	@Resource
	private OrderService orderService;

	@GetMapping("/order/create")
	public CommonResult create(Order order){
		orderService.create(order);
		return new CommonResult(200, "创建订单成功");
	}
}
