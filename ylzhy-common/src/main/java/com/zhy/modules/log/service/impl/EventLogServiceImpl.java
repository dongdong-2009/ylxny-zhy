package com.zhy.modules.log.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.log.dao.EventLogDao;
import com.zhy.modules.log.entity.EventLogEntity;
import com.zhy.modules.log.service.EventLogService;


@Service("eventLogService")
public class EventLogServiceImpl extends ServiceImpl<EventLogDao, EventLogEntity> implements EventLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<EventLogEntity> page = this.selectPage(
                new Query<EventLogEntity>(params).getPage(),
                new EntityWrapper<EventLogEntity>()
        );

        return new PageUtils(page);
    }

}
