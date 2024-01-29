package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author lowo
 * @email 870050851@qq.com
 * @date 2022-04-17 16:52:45
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
