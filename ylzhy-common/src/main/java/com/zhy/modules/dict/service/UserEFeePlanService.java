package com.zhy.modules.dict.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.dict.entity.UserEFeePlanEntity;

import java.util.Map;

/**
 * 电价方案
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-11 15:55:52
 */
public interface UserEFeePlanService extends IService<UserEFeePlanEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

