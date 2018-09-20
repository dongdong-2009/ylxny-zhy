package com.zhy.modules.alarm.dao;

import com.zhy.modules.alarm.entity.AlarmRankEntity;
import com.zhy.modules.alarm.entity.AlarmSummaryEntity;
import com.zhy.modules.alarm.entity.UserAlarmRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-17 13:57:51
 */
public interface UserAlarmRecordDao extends BaseMapper<UserAlarmRecordEntity> {

    List<AlarmSummaryEntity> summary(@Param("companyId") Long companyId);

    List<AlarmRankEntity> waterCrossRank(Map<String, Object> map);
}
