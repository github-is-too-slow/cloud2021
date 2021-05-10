package com.billion.springcloud.service.impl;

import com.billion.springcloud.service.MessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-02 17:17
 */
@EnableBinding(Source.class)
public class MessageServiceImpl implements MessageService{
	@Resource
	private MessageChannel output;

	@Override
	public String sendMsg(String msg) {
		System.out.println("*******msg = " + msg);
		output.send(MessageBuilder.withPayload(msg).build());
		return null;
	}
}
