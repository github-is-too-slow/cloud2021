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

	@GetMapping("/payment/consul")
	public String getPort(){
		return "payment service with Consul, port is: " + serverPort + UUID.randomUUID().toString();
	}
}
