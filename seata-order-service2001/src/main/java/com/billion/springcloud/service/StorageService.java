package com.billion.springcloud.service;

import com.billion.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Billion
 * @create 2021-05-07 16:42
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
	@PostMapping("/storage/decrease")
	CommonResult decrease(@RequestParam("produceId") Long productId,
	                      @RequestParam("count") Integer count);
}
