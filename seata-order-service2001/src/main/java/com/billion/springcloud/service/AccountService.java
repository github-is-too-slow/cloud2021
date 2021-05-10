package com.billion.springcloud.service;

import com.billion.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021-05-07 16:42
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
	@PostMapping("/account/decrease")
	CommonResult decrease(@RequestParam("userId") Long userId,
	                      @RequestParam("money") BigDecimal money);
}
