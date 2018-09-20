package com.zhy.modules.dict.service.impl;

import com.zhy.modules.dict.dao.UserEFeePlanDao;
import com.zhy.modules.dict.entity.UserEFeePlanEntity;
import com.zhy.modules.dict.service.UserEFeePlanService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;


@Service("userEFeePlanService")
public class UserEFeePlanServiceImpl extends ServiceImpl<UserEFeePlanDao, UserEFeePlanEntity> implements UserEFeePlanService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserEFeePlanEntity> page = this.selectPage(
                new Query<UserEFeePlanEntity>(params).getPage(),
                new EntityWrapper<UserEFeePlanEntity>()
        );

        return new PageUtils(page);
    }

}
