package com.billion.service;

import com.billion.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Billion
 * @create 2021-04-19 20:35
 */
public interface PaymentService {
	int create(Payment payment);
	Payment getById(Long id);
}
