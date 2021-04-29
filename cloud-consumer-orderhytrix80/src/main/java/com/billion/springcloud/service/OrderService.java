package com.billion.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Billion
 * @create 2021/04/28 22:49
 */
@Service
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface OrderService {
    @GetMapping("/payment/hythrix/ok/{id}")
    String getInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hythrix/timeout/{id}")
    String getInfoTimeout(@PathVariable("id") Integer id);
}
