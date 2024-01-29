package com.atguigu.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author lowo
 * @email 870050851@qq.com
 * @date 2022-04-17 15:11:25
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<CategoryEntity> listWithTree();

	void removeMenuByIds(List<Long> asList);

	/**
	 * 找到catelogId的完整路径；
	 * [父/子/孙]
	 * @param catelogId
	 * @return
	 */
	Long[] findCatelogPath(Long catelogId);

}

