package com.billion.springcloud.mapper;

import com.billion.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Billion
 * @create 2021-05-07 16:09
 */
@Mapper
public interface OrderMapper {
	//1.创建订单
	int insert(Order order);

	//2.更新订单状态
	int update(@Param("orderId") Long orderId, @Param("status") Integer status);
}
