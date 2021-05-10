package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Billion
 * @create 2021-05-04 21:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3377 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientMain3377.class, args);
	}
}
