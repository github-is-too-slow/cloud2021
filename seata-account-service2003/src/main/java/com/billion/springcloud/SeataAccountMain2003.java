package com.billion.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Billion
 * @create 2021-05-07 18:09
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataAccountMain2003 {
	public static void main(String[] args) {
		SpringApplication.run(SeataAccountMain2003.class, args);
	}
}
