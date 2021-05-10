package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Billion
 * @create 2021-05-04 16:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain9001.class, args);
	}
}
