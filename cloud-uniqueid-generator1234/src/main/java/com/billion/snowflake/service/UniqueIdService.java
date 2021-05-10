package com.billion.snowflake.service;

/**
 * @author Billion
 * @create 2021-05-08 14:22
 */
public interface UniqueIdService {
	Long getUniqueId();
	Long getUniqueId(Long workerId, Long datacenterId);
}
