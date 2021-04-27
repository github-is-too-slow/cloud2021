package com.billion.mapper;

import com.billion.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Billion
 * @create 2021-04-19 20:05
 */
@Mapper
public interface PaymentMapper {
	int insert(Payment payment);
	Payment selectById(@Param("id") Long id);
}
