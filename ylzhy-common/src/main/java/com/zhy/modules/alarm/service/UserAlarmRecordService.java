package com.zhy.modules.alarm.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.alarm.entity.UserAlarmRecordEntity;
import net.sf.json.JSONObject;

import java.util.Date;
import java.util.Map;

/**
 * 
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-17 13:57:51
 */
public interface UserAlarmRecordService extends IService<UserAlarmRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

    JSONObject summary(Long companyId);

    JSONObject waterCrossRank(int type, Long lineId, String startDate, String endDate);

    PageUtils queryByForm(Map<String, Object> params);
}

