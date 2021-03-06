package com.billion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Billion
 * @create 2021-04-22 18:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8005 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentConsulMain8005.class, args);
	}
}
