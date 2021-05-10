package com.billion.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Billion
 * @create 2021-05-07 17:39
 */
@Mapper
public interface StorageMapper {
	int update(@Param("productId") Long productId, @Param("count") Integer count);
}
