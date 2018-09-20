package com.zhy.modules.qxgl.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.zhy.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.modules.qxgl.entity.MenuEntity;
import com.zhy.modules.qxgl.service.MenuService;
 
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;



/**
 * 菜单管理
 *
 * @author ylzg
 * @email ylzg@163.com
 * @date 2018-09-10 14:14:22
 */
@RestController
@RequestMapping("qxgl/menu")
public class MenuController extends AbstractController{
    @Autowired
    private MenuService menuService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("qxgl:menu:list")
    public R list(@RequestParam Map<String, Object> params){
    	List<MenuEntity> menuList = menuService.getUserMenuList(getUserId());
		return R.ok().put("menuList", menuList);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{menuId}")
    //@RequiresPermissions("qxgl:menu:info")
    public R info(@PathVariable("menuId") Long menuId){
        MenuEntity menu = menuService.selectById(menuId);

        return R.ok().put("menu", menu);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("qxgl:menu:save")
    public R save(@RequestBody MenuEntity menu){
        menuService.insert(menu);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("qxgl:menu:update")
    public R update(@RequestBody MenuEntity menu){
        ValidatorUtils.validateEntity(menu);
        menuService.updateAllColumnById(menu);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("qxgl:menu:delete")
    public R delete(@RequestBody Long[] menuIds){
        menuService.deleteBatchIds(Arrays.asList(menuIds));

        return R.ok();
    }

}
