package com.billion.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author Billion
 * @create 2021-05-02 23:12
 */
@Controller
@EnableBinding(Sink.class)
public class StreamListenerController {
	@Value("${server.port}")
	private Integer serverPort;

	@StreamListener(Sink.INPUT)
	public void input(Message<String> message){
		System.out.println("消费者1号msg = " + message.getPayload() + "\t port = " + serverPort);
	}

}
