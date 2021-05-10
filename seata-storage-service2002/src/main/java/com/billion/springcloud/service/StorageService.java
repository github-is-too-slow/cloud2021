package com.billion.springcloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author Billion
 * @create 2021-05-07 17:46
 */
public interface StorageService {
	void decrease(Long productId, Integer count);
}
