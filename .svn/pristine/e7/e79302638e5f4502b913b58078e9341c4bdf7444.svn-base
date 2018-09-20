package com.zhy.modules.qxgl.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;
import com.zhy.common.validator.Assert;
import com.zhy.common.validator.ValidatorUtils;
import com.zhy.modules.qxgl.entity.UserEntity;
import com.zhy.modules.qxgl.service.UserService;
import com.zhy.modules.qxgl.shiro.ShiroUtils;



/**
 * 
 *
 * @author ylzg
 * @email ylzg@163.com
 * @date 2018-09-10 14:26:01
 */
@RestController
@RequestMapping("qxgl/user")
public class UserController  extends AbstractController{
    @Autowired
    private UserService userService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("qxgl:user:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userService.queryPage(params);

        return R.ok().put("page", page);
    }


	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
	
	    UserEntity user=getUser();  
	    System.err.println("user.....name....."+user.getUsername());
	    System.err.println("user.....company....."+user.getCompanyId());
		return R.ok().put("user", getUser());
	}

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("qxgl:user:save")
    public R save(@RequestBody UserEntity user){
        userService.insert(user);

        return R.ok();
    }
    /**
	 * 修改登录用户密码
	 */
 
	@RequestMapping("/password")
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");

		//原密码
		password = ShiroUtils.sha256(password, getUser().getSalt());
		//新密码
		newPassword = ShiroUtils.sha256(newPassword, getUser().getSalt());
				
		//更新密码
		boolean flag = userService.updatePassword(getUserId(), password, newPassword);
		if(!flag){
			return R.error("原密码不正确");
		}
		
		return R.ok();
	}
    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("qxgl:user:update")
    public R update(@RequestBody UserEntity user){
        ValidatorUtils.validateEntity(user);
        userService.updateAllColumnById(user);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("qxgl:user:delete")
    public R delete(@RequestBody Long[] userIds){
        userService.deleteBatchIds(Arrays.asList(userIds));

        return R.ok();
    }

}
