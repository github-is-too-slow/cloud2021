package com.billion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Billion
 * @create 2021-04-16 18:50
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Payment implements Serializable{
	private Long id;
	private String serial;
}
