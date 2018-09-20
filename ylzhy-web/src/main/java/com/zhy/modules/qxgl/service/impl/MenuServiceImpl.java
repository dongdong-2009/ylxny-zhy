package com.zhy.modules.qxgl.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.Constant;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.qxgl.dao.MenuDao;
import com.zhy.modules.qxgl.entity.MenuEntity;
import com.zhy.modules.qxgl.service.MenuService;
 

@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MenuEntity> page = this.selectPage(
                new Query<MenuEntity>(params).getPage(),
                new EntityWrapper<MenuEntity>().eq("xybz", "Y")
        );

        return new PageUtils(page);
    }

	@Override
	public List<MenuEntity> getUserMenuList(Long userId) {
		// TODO Auto-generated method stub
		return getAllMenuList(null);
	}
	/**
	 * 获取所有菜单列表
	 */
	private List<MenuEntity> getAllMenuList(List<Long> menuIdList){
		//查询根菜单列表
		List<MenuEntity> menuList = queryListParentId(0L, menuIdList);
	 
		 for(MenuEntity e:menuList){
			 
		 }
		//递归获取子菜单
		getMenuTreeList(menuList, menuIdList);
		 
		return menuList;
	}

	/**
	 * 递归
	 */
	private List<MenuEntity> getMenuTreeList(List<MenuEntity> menuList, List<Long> menuIdList){
		List<MenuEntity> subMenuList = new ArrayList<MenuEntity>();
		
		for(MenuEntity entity : menuList){
			//目录
			 
			if(entity.getType() == Constant.MenuType.CATALOG.getValue()){
				 
				entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
			}
			subMenuList.add(entity);
			 
		}
		
		return subMenuList;
	}
	
 
	public List<MenuEntity> queryListParentId(Long parentId, List<Long> menuIdList) {
	 
		List<MenuEntity> menuList = queryListParentId(parentId);
		 
		if(menuIdList == null){
			return menuList;
		}
		
		List<MenuEntity> userMenuList = new ArrayList<>();
		for(MenuEntity menu : menuList){
			if(menuIdList.contains(menu.getMenuId())){
				userMenuList.add(menu);
			}
		}
		return userMenuList;
	}

	 
	public List<MenuEntity> queryListParentId(Long parentId) {
		return baseMapper.queryListParentId(parentId);
	}
}
