package com.billion.snowflake.controller;

import com.billion.entity.CommonResult;
import com.billion.snowflake.service.UniqueIdService;
import com.billion.snowflake.utils.IdGeneratorSnowflakeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.server.UnicastServerRef;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Billion
 * @create 2021-05-08 14:25
 */
@RestController
public class UniqueIdController {
	@Resource
	private UniqueIdService uniqueIdService;

	@GetMapping("/uniqueId")
	public CommonResult getUniqueId(@RequestParam(value = "workerId", required = false) Long workerId,
	                                @RequestParam(value = "datacenterId", required = false) Long datacenterId){
		Long uniqueId;
		if(workerId == null || datacenterId == null){
			uniqueId = uniqueIdService.getUniqueId();
		}else {
			uniqueId = uniqueIdService.getUniqueId(workerId, datacenterId);
		}
		return new CommonResult(200, "获取分布式唯一ID成功", uniqueId);
	}

	public static void main(String[] args) {
		IdGeneratorSnowflakeUtil idGenerator = new IdGeneratorSnowflakeUtil();
		//多线程请求ID
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			threadPool.submit(() -> {
				System.out.println(idGenerator.nextId());
			});
		}
		threadPool.shutdown();
	}
}
