package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Billion
 * @create 2021-05-05 19:11
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8401 {
	public static void main(String[] args) {
		SpringApplication.run(SentinelMain8401.class, args);
	}
}
