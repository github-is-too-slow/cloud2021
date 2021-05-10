package com.billion.springcloud.service.impl;

import com.billion.springcloud.mapper.StorageMapper;
import com.billion.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-07 17:47
 */
@Service
public class StorageServiceImpl implements StorageService {
	@Resource
	private StorageMapper storageMapper;

	@Override
	public void decrease(Long productId, Integer count) {
		storageMapper.update(productId, count);
	}
}
