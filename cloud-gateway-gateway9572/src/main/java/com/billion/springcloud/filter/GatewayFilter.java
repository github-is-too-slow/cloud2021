package com.billion.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Billion
 * @create 2021-04-30 13:48
 */
@Component
public class GatewayFilter implements GlobalFilter, Ordered{


	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
		if (uname == null) {
			System.out.println("用户名不能为空");
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		//表示过滤器优先级，数字越小，优先级越高
		return 0;
	}
}
