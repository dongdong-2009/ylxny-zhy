package com.zhy.modules.log.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.log.dao.FailLogDao;
import com.zhy.modules.log.entity.FailLogEntity;
import com.zhy.modules.log.service.FailLogService;


@Service("failLogService")
public class FailLogServiceImpl extends ServiceImpl<FailLogDao, FailLogEntity> implements FailLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FailLogEntity> page = this.selectPage(
                new Query<FailLogEntity>(params).getPage(),
                new EntityWrapper<FailLogEntity>()
        );

        return new PageUtils(page);
    }

}
