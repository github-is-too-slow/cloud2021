package com.billion.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import com.billion.springcloud.service.FeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-06 15:14
 */
@RestController
public class OrderController {
	private static final String SERVICE_URL = "http://cloudalibaba-payment-service";
	@Resource
	private FeignService feignService;

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/consumer/get2")
	@SentinelResource(value = "blockhandler", blockHandler = "blockHandler")
	public CommonResult getById2(@RequestParam("id") Long id){
		return feignService.getById(id);
	}

	@GetMapping("/consumer/get/{id}")
//	@SentinelResource(value = "fallback", fallback = "fallbackHandler")
//	@SentinelResource(value = "fallback", blockHandler = "blockHandler")
	@SentinelResource(value = "fallback",
			fallback = "fallbackHandler",
			blockHandler = "blockHandler",
			exceptionsToIgnore = {IllegalArgumentException.class})
	public CommonResult getById(@PathVariable("id") Long id) {
		if(id == 4){
			throw new IllegalArgumentException("非法参数异常");
		}else if(id > 4){
			throw new NullPointerException("空指针异常");
		}
		CommonResult res = restTemplate.getForObject(SERVICE_URL + "/get/" + id, CommonResult.class);
		return res;
	}

	public CommonResult fallbackHandler(Long id, Throwable e){
		Payment payment = new Payment(id, null);
		return new CommonResult(444, "fallback运行时异常兜底" + e.getMessage(), payment);
	}

	public CommonResult blockHandler(Long id, BlockException e){
		Payment payment = new Payment(id, null);
		return new CommonResult(455, "block配置违规降级处理" + e.getMessage(), payment);
	}
}
