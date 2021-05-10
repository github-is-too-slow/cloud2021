package com.billion.springcloud.service;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021-05-07 18:04
 */
public interface AccountService {
	void decrease(Long userId, BigDecimal money);
}
