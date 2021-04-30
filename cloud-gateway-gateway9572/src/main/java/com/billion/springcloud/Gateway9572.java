package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Billion
 * @create 2021-04-30 12:39
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9572 {
	public static void main(String[] args) {
		SpringApplication.run(Gateway9572.class, args);
	}
}
