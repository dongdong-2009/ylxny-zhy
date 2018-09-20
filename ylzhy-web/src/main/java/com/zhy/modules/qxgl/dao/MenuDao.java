package com.zhy.modules.qxgl.dao;

import com.zhy.modules.qxgl.entity.MenuEntity;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 菜单管理
 * 
 * @author ylzg
 * @email ylzg@163.com
 * @date 2018-09-10 14:14:22
 */
public interface MenuDao extends BaseMapper<MenuEntity> {

	List<MenuEntity> queryListParentId(Long parentId);
	
}
