package com.billion.springcloud.controller;

import com.billion.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021/04/28 21:10
 */
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hythrix/ok/{id}")
    public String getInfoOk(@PathVariable("id") Integer id){
        return paymentService.getInfoOk(id);
    }


    @GetMapping("/payment/hythrix/timeout/{id}")
    public String getInfoTimeout(@PathVariable("id") Integer id){
        return paymentService.getInfoTimeout(id);
    }
}
