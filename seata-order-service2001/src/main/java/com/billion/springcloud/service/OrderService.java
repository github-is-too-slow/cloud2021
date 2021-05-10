package com.billion.springcloud.service;

import com.billion.springcloud.domain.Order;

/**
 * @author Billion
 * @create 2021-05-07 16:31
 */
public interface OrderService {
	//创建订单
	void create(Order order);
}
