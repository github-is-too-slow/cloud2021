package com.billion.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Billion
 * @create 2021-05-04 21:15
 */
@RestController
@RefreshScope   //nacos自动具有自动刷新功能
public class ConfigController {
	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config/info")
	public String getConfigInfo(){
		return configInfo;
	}
}

