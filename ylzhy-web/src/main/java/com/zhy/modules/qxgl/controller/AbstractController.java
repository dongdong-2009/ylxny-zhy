/**
 * Copyright 2018 智慧云
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

package com.zhy.modules.qxgl.controller;

import java.util.Map;

import com.zhy.common.utils.CommonUtil;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhy.modules.company.entity.CompanySbxxEntity;
import com.zhy.modules.company.service.CompanyService;
import com.zhy.modules.qxgl.entity.UserEntity;

/**
 * Controller公共组件
 * 
 * @author chenshun
 * @email 
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	 @Autowired
	 private CompanyService companyService;
	protected UserEntity getUser() {
		return (UserEntity) SecurityUtils.getSubject().getPrincipal();
	}

	protected Long getCompanyId(){
		return CommonUtil.getLong(getUser().getCompanyId());
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
	protected UserEntity getUser(boolean getMainLine) {
		
		UserEntity u= (UserEntity) SecurityUtils.getSubject().getPrincipal();
		if(getMainLine){
			 Map<String,Object>  MainLine	=companyService.getCompanyMainLine(u.getCompanyId());
			if(MainLine!=null){
				u.setMainLine(Integer.valueOf(String.valueOf(MainLine.get("mainLine"))));
				u.setMainLineName(String.valueOf(MainLine.get("mainLineName")));
			}
		}
		return u;
	}
}
