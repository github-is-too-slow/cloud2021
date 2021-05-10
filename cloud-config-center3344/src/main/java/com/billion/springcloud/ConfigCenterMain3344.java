package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Billion
 * @create 2021-05-01 20:35
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigCenterMain3344.class, args);
	}
}
