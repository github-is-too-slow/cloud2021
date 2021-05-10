package com.billion.snowflake.service.impl;

import com.billion.snowflake.service.UniqueIdService;
import com.billion.snowflake.utils.IdGeneratorSnowflakeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Billion
 * @create 2021-05-08 14:23
 */
@Service
public class UniqueIdServiceImpl implements UniqueIdService {
	@Resource
	private IdGeneratorSnowflakeUtil idGenerator;

	@Override
	public Long getUniqueId() {
		return idGenerator.nextId();
	}

	@Override
	public Long getUniqueId(Long workerId, Long datacenterId) {
		return idGenerator.nextId(workerId, datacenterId);
	}
}
