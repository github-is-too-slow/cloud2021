package com.billion.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Billion
 * @create 2021-05-02 16:48
 */
@RestController
@RefreshScope
public class ConfigController {
	@Value("${server.port}")
	private Integer serverPort;

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config/info")
	public String getConfigInfo(){
		return  configInfo + " port = " + serverPort;
	}
}
