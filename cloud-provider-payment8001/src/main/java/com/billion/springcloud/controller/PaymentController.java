package com.billion.springcloud.controller;

import com.billion.entity.CommonResult;
import com.billion.entity.Payment;
import com.billion.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Billion
 * @create 2021-04-19 20:40
 */
@RestController
@Slf4j
public class PaymentController {
	@Resource
	private PaymentService paymentService;
	@Resource
	private DiscoveryClient discoveryClient;
	@Value("${server.port}")
	private Integer serverPort;

	@PostMapping("/payment/create")
	public CommonResult create(@RequestBody Payment payment){
		System.out.println(payment);
		int result = paymentService.create(payment);
		log.info("插入结果：" + result);
		if(result > 0){
			return new CommonResult<>(200, "创建订单成功，服务端口号：" + serverPort, result);
		}else {
			return new CommonResult<>(444, "创建订单失败，服务端口号：" + serverPort, result);
		}
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult getById(@PathVariable("id") Long id){
		Payment result = paymentService.getById(id);
		log.info("查询结果：" + result);
		if(result != null){
			return new CommonResult<>(200, "查询成功，服务端口号：" + serverPort, result);
		}else {
			return new CommonResult<>(444, "查询失败，无对应订单编号：" + id + "，服务端口号：" + serverPort, result);
		}
	}

	@GetMapping("/payment/discovery")
	public Object discoveryInfo(){
		List<String> services = discoveryClient.getServices();
		for(String service: services){
			log.info("####" + service);
		}
		List<ServiceInstance> instances = discoveryClient.getInstances(services.get(0));
		for(ServiceInstance instance: instances){
			log.info("serviceId: " + instance.getServiceId() + " host: " + instance.getHost() +
					" port: " + instance.getPort() + " uri: " + instance.getUri());
		}
		return this.discoveryClient;
	}

	@GetMapping("/payment/port")
	public CommonResult getServerPort(){
		return new CommonResult<>(200, "success", serverPort);
	}
}
