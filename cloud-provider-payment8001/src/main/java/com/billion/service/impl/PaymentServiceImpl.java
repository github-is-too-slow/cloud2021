package com.billion.service.impl;

import com.billion.entity.Payment;
import com.billion.mapper.PaymentMapper;
import com.billion.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-04-19 20:37
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	@Resource
	private PaymentMapper paymentMapper;

	@Override
	public int create(Payment payment) {
		return paymentMapper.insert(payment);
	}

	@Override
	public Payment getById(Long id) {
		return paymentMapper.selectById(id);
	}
}
