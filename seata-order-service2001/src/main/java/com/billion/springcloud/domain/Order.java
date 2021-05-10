package com.billion.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021-05-07 14:29
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Order {
	private Long id;
	private Long userId;
	private Long productId;
	private Integer count;
	private BigDecimal money;
	private Integer status;
}
