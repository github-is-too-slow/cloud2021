package com.billion.springcloud.controller;

import com.billion.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021/04/28 22:52
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/hythrix/ok/{id}")
    public String getInfoOk(@PathVariable("id") Integer id){
        return orderService.getInfoOk(id);
    }

    @HystrixCommand(fallbackMethod = "timeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    @GetMapping("/order/hythrix/timeout/{id}")
    public String getInfoTimeout(@PathVariable("id") Integer id){
        int i = 10 / 0;
        return orderService.getInfoTimeout(id);
    }

    public String timeoutHandle(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 对方服务超时或出错，请稍后尝试 " + "id: " +id + " o(╥﹏╥)o";
    }
}
