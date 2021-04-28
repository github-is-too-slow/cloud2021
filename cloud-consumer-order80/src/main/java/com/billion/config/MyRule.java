package com.billion.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Billion
 * @create 2021-04-28 10:27
 */
@Configuration
public class MyRule {
	@Bean
	public IRule getRule(){
		return new RandomRule();
	}
}
