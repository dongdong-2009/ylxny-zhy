package com.zhy.modules.alarm.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.alarm.dao.SysAlarmSettingDao;
import com.zhy.modules.alarm.entity.SysAlarmSettingEntity;
import com.zhy.modules.alarm.service.SysAlarmSettingService;


@Service("sysAlarmSettingService")
public class SysAlarmSettingServiceImpl extends ServiceImpl<SysAlarmSettingDao, SysAlarmSettingEntity> implements SysAlarmSettingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysAlarmSettingEntity> page = this.selectPage(
                new Query<SysAlarmSettingEntity>(params).getPage(),
                new EntityWrapper<SysAlarmSettingEntity>()
        );

        return new PageUtils(page);
    }

}
