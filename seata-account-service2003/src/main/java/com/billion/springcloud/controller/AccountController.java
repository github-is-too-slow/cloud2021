package com.billion.springcloud.controller;

import com.billion.entity.CommonResult;
import com.billion.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021-05-07 18:07
 */
@RestController
public class AccountController {
	@Resource
	private AccountService accountService;

	@PostMapping("/account/decrease")
	CommonResult decrease(@RequestParam("userId") Long userId,
	                      @RequestParam("money") BigDecimal money){
		accountService.decrease(userId, money);
		return new CommonResult(200, "扣除余额成功");
	}
}
