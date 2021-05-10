package com.billion.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.billion.entity.CommonResult;

/**
 * @author Billion
 * @create 2021-05-06 12:02
 */
public class CustomSentinelHandler {
	public static CommonResult handler1(BlockException exception){
		return new CommonResult(404, exception.getMessage() + "降级处理1");
	}

	public static CommonResult handler2(BlockException exception){
		return new CommonResult(404, exception.getMessage() + "降级处理2");
	}
}
