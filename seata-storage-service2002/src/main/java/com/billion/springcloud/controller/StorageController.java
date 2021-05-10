package com.billion.springcloud.controller;

import com.billion.entity.CommonResult;
import com.billion.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-07 17:50
 */
@RestController
public class StorageController {
	@Resource
	private StorageService storageService;

	@PostMapping("/storage/decrease")
	CommonResult decrease(@RequestParam("produceId") Long productId,
	                      @RequestParam("count") Integer count){
		storageService.decrease(productId, count);
		return new CommonResult(200, "扣除库存成功");
	}
}
