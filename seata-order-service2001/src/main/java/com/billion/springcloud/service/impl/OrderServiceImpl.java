package com.billion.springcloud.service.impl;

import com.billion.springcloud.domain.Order;
import com.billion.springcloud.mapper.OrderMapper;
import com.billion.springcloud.service.AccountService;
import com.billion.springcloud.service.OrderService;
import com.billion.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-07 16:53
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private StorageService storageService;
	@Resource
	private AccountService accountService;

	@Override
	@GlobalTransactional(name = "billion-create-order", rollbackFor = Exception.class)
	public void create(Order order) {
		log.info("下订单start");
		orderMapper.insert(order);
		log.info("下订单end");
		System.out.println(order);
		log.info("减库存start");
		storageService.decrease(order.getProductId(), order.getCount());
		log.info("减库存end");

		log.info("扣余额start");
		accountService.decrease(order.getUserId(), order.getMoney());
		log.info("扣余额end");

		log.info("改状态start");
		orderMapper.update(order.getId(), order.getStatus());
		log.info("改状态end");
		log.info("订单完成，哈哈哈O(∩_∩)O哈哈~");
	}
}
