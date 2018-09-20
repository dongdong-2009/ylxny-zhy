package com.zhy.modules.alarm.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.alarm.entity.SysAlarmSettingEntity;

import java.util.Map;

/**
 * 报警设置
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-17 13:57:52
 */
public interface SysAlarmSettingService extends IService<SysAlarmSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

