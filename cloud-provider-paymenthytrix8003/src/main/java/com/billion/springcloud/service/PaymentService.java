package com.billion.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Billion
 * @create 2021/04/28 21:07
 */
@Service
public class PaymentService {
    public String getInfoOk(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " request OK " + "id: " + id + " O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "timeoutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getInfoTimeout(Integer id){
        int timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " request timeout " + "id: " +id + " o(╥﹏╥)o";
    }

    public String timeoutHandle(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 服务端出错，请稍后重试 " + "id: " +id + " o(╥﹏╥)o";
    }
}
