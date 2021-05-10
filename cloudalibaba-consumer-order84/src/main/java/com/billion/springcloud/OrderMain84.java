package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Billion
 * @create 2021-05-06 15:13
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderMain84 {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain84.class, args);
	}
}
