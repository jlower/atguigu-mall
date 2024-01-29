package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author lowo
 * @email 870050851@qq.com
 * @date 2022-04-17 16:42:01
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
