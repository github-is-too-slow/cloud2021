package com.billion.springcloud.handler;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.billion.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Billion
 * @create 2021-05-06 12:05
 */
@RestController
public class RateLimitController {
	@GetMapping("/customHandler")
	@SentinelResource(value = "customHandler",
			blockHandlerClass = CustomSentinelHandler.class,
			blockHandler = "handler2")
	public CommonResult customHandler(){
		return new CommonResult(200, "请求成功", "恭喜请求成功");
	}
}
