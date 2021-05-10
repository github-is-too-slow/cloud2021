package com.billion.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Billion
 * @create 2021-05-05 19:12
 */
@RestController
@Slf4j
public class FlowlimitController {
	@GetMapping("/testA")
	public String testA(){
		log.info(Thread.currentThread().getName() + " testA");
		return "*********testA*****";
	}

	@GetMapping("/testB")
	public String testB(){
		return "*********testB*****";
	}

	@GetMapping("/testD")
	public String testD() {
//		TimeUnit.SECONDS.sleep(1);
//		log.info("test rt平均响应时间");
		log.info("test 异常比例");
		int i = 10 / 0;
		return "*********testD*****";
	}

	@GetMapping("/testhot")
	@SentinelResource(value = "testhot", blockHandler = "deal")
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
	                         @RequestParam(value = "p2", required = false) String p2){
		return "****test hot key********";
	}

	public String deal(String p1, String p2, BlockException exception){
		return "*****handle testHotKey,o(╥﹏╥)o*********";
	}
}
