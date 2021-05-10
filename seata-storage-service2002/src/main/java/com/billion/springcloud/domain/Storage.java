package com.billion.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Billion
 * @create 2021-05-07 17:35
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Storage {
	private Long id;
	private Long productId;
	private Integer total;
	private Integer used;
	private Integer residue;
}
