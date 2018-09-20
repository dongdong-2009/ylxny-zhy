/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.zhy.modules.qxgl.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.exception.RRException;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;
import com.zhy.common.utils.ShiroUtils;
import com.zhy.common.validator.Assert;
import com.zhy.form.LoginForm;
import com.zhy.modules.qxgl.dao.UserDao;
import com.zhy.modules.qxgl.entity.TokenEntity;
import com.zhy.modules.qxgl.entity.UserEntity;
import com.zhy.modules.qxgl.service.TokenService;
import com.zhy.modules.qxgl.service.UserService;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private TokenService tokenService;

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}

	@Override
	public Map<String, Object> login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		
		if(!user.getPassword().equals(ShiroUtils.sha256(form.getPassword(), user.getSalt()))){
			throw new RRException("手机号或密码错误");
		}

		//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(user.getUserId());

		Map<String, Object> map = new HashMap<>(2);
		map.put("token", tokenEntity.getToken());
		map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

		return map;
	}
	 @Override
	    public PageUtils queryPage(Map<String, Object> params) {
	        Page<UserEntity> page = this.selectPage(
	                new Query<UserEntity>(params).getPage(),
	                new EntityWrapper<UserEntity>()
	        );

	        return new PageUtils(page);
	    }


		@Override
		public boolean updatePassword(Long userId, String password, String newPassword) {
	         UserEntity userEntity = new UserEntity();
	        userEntity.setPassword(newPassword);
	        return this.update(userEntity,
	                new EntityWrapper<UserEntity>().eq("userId", userId).eq("password", password));
	    }
		
}
