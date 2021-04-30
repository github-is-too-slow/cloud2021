package com.billion.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author Billion
 * @create 2021-04-29 12:53
 */
@Service
public class OrderFallbackService implements OrderService{
	@Override
	public String getInfoOk(Integer id) {
		return "线程池：" + Thread.currentThread().getName() + " 调用OK失败 " + " id: " + id + "o(╥﹏╥)o";
	}

	@Override
	public String getInfoTimeout(Integer id) {
		return "线程池：" + Thread.currentThread().getName() + " 调用超时 " + " id: " + id + "o(╥﹏╥)o";
	}
}
