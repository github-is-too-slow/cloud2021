package com.billion.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Billion
 * @create 2021-04-28 11:21
 */
@Configuration
public class OpenFeignConfig {
	@Bean
	public Logger.Level setLevel(){
		return Logger.Level.FULL;
	}
}
