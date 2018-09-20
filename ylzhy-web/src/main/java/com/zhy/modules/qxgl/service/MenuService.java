package com.zhy.modules.qxgl.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.qxgl.entity.MenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 * @author ylzg
 * @email ylzg@163.com
 * @date 2018-09-10 14:14:22
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

	List<MenuEntity> getUserMenuList(Long userId);
}

