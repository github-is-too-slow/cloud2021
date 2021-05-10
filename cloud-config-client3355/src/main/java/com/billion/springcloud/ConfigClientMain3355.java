package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Billion
 * @create 2021-05-01 21:47
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientMain3355.class, args);
	}
}
