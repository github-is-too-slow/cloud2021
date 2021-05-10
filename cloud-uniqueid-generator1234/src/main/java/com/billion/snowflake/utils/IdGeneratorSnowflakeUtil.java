package com.billion.snowflake.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Billion
 * @create 2021-05-08 14:12
 */
@Component
@Slf4j
public class IdGeneratorSnowflakeUtil {
	private Long workerId = 0L;
	private Long datacenterId = 0L;
	private Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);

	@PostConstruct
	public void init(){
	}

	public synchronized Long nextId(){
		return snowflake.nextId();
	}

	public synchronized Long nextId(Long workerId, Long datacenterId){
		Snowflake snowflake = IdUtil.createSnowflake(workerId, datacenterId);
		return snowflake.nextId();
	}
}
