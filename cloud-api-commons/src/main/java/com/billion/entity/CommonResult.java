package com.billion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Billion
 * @create 2021-04-16 18:52
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
	private Integer code;
	private String message;
	private T data;

	public CommonResult(Integer code, String message){
		this(code, message, null);
	}
}
