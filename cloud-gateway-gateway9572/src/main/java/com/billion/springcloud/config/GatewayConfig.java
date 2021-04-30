package com.billion.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Billion
 * @create 2021-04-30 13:15
 */
@Configuration
public class GatewayConfig {
	@Bean
	public RouteLocator setRoute(RouteLocatorBuilder builder){
		RouteLocatorBuilder.Builder routes = builder.routes();
		routes.route("guoneinews", r -> r.path("/guoji")
				.uri("http://news.baidu.com/guoji")).build();
		return routes.build();
	}
}
