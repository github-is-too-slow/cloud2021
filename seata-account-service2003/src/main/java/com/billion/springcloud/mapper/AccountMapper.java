package com.billion.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Billion
 * @create 2021-05-07 17:59
 */
@Mapper
public interface AccountMapper {
	int update(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
