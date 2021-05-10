package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Billion
 * @create 2021-05-06 13:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9003 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain9003.class, args);
	}
}
