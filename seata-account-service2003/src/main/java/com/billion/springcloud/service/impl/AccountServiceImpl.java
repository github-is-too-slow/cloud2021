package com.billion.springcloud.service.impl;

import com.billion.springcloud.mapper.AccountMapper;
import com.billion.springcloud.service.AccountService;
import com.mysql.jdbc.TimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author Billion
 * @create 2021-05-07 18:05
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Resource
	private AccountMapper accountMapper;

	@Override
	public void decrease(Long userId, BigDecimal money) {
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		accountMapper.update(userId, money);
	}
}
