package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author lowo
 * @email 870050851@qq.com
 * @date 2022-04-17 16:32:34
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
