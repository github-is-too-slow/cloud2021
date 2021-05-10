package com.billion.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Billion
 * @create 2021-05-04 16:47
 */
@RestController
public class PaymentController {
	@Value("${server.port}")
	private Integer serverPort;

	@GetMapping("/payment/nacos/{id}")
	public String getInfo(@PathVariable Integer id){
		return "Alibaba Nacos registra success, server port = " + serverPort + " id = " + id;
	}
}
