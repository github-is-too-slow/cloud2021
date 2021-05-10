package com.billion.springcloud.controller;

import com.billion.springcloud.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Billion
 * @create 2021-05-02 17:24
 */
@RestController
public class MessageController {
	@Resource
	private MessageService messageService;

	@GetMapping("/send/serial")
	public void sendMessage(){
		String serial = UUID.randomUUID().toString();
		messageService.sendMsg(serial);
	}
}
