package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Billion
 * @create 2021-04-29 13:54
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard9001 {
	public static void main(String[] args) {
		SpringApplication.run(Dashboard9001.class, args);
	}
}
