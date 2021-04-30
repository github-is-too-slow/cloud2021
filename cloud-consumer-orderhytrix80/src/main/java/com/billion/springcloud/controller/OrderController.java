package com.billion.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.billion.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
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
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {
    @Resource
    private OrderService orderService;

    @HystrixCommand
    @GetMapping("/order/hythrix/ok/{id}")
    public String getInfoOk(@PathVariable("id") Integer id){
        return orderService.getInfoOk(id);
    }

//    @HystrixCommand(fallbackMethod = "timeoutHandle", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
    @HystrixCommand
    @GetMapping("/order/hythrix/timeout/{id}")
    public String getInfoTimeout(@PathVariable("id") Integer id){
        int i = 10 / 0;
        return orderService.getInfoTimeout(id);
    }

    public String timeoutHandle(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 对方服务超时或出错，请稍后尝试 " + "id: " +id + " o(╥﹏╥)o";
    }

    //全局服务降级方法
    public  String globalFallback(){
        return "线程池：" + Thread.currentThread().getName() + " 全局服务降级方法执行 " + "id: " + " o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "circuitFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    @GetMapping("/order/hystrix/breaker/{id}")
    public String getInfoWithBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("id不能为负数，请重试");
        }
        String uuid = IdUtil.simpleUUID();
        return "访问正常： id= " + id + " uuid= " + uuid;
    }

    public String circuitFallback(Integer id){
        return "id不能为负数，服务熔断：id= " + id;
    }
}
