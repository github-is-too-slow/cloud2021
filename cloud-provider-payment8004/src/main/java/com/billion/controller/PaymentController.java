package com.billion.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Billion
 * @create 2021-04-22 16:15
 */
@RestController
public class PaymentController {
	@Value("${server.port}")
	private Integer serverPort;

	@GetMapping("/payment/zk")
	public String getPort(){
		return "payment service with Zookeeper, port is: " + serverPort + UUID.randomUUID().toString();
	}
}
