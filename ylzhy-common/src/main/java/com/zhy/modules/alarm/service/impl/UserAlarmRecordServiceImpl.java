package com.zhy.modules.alarm.service.impl;

import com.zhy.common.utils.CommonUtil;
import com.zhy.common.utils.DateUtils;
import com.zhy.modules.alarm.dao.SysAlarmSettingDao;
import com.zhy.modules.alarm.entity.AlarmRankEntity;
import com.zhy.modules.alarm.entity.AlarmSummaryEntity;
import com.zhy.modules.alarm.entity.SysAlarmSettingEntity;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.alarm.dao.UserAlarmRecordDao;
import com.zhy.modules.alarm.entity.UserAlarmRecordEntity;
import com.zhy.modules.alarm.service.UserAlarmRecordService;


@Service("userAlarmRecordService")
public class UserAlarmRecordServiceImpl extends ServiceImpl<UserAlarmRecordDao, UserAlarmRecordEntity> implements UserAlarmRecordService {

    @Autowired
    UserAlarmRecordDao userAlarmRecordDao;
    @Autowired
    SysAlarmSettingDao sysAlarmSettingDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserAlarmRecordEntity> page = this.selectPage(
                new Query<UserAlarmRecordEntity>(params).getPage(),
                new EntityWrapper<UserAlarmRecordEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public JSONObject summary(Long companyId) {
        List<AlarmSummaryEntity> list = userAlarmRecordDao.summary(companyId);
        JSONObject obj = new JSONObject();
        CommonUtil.add2Json(obj, "datas", list);
        return obj;
    }

    @Override
    public JSONObject waterCrossRank(int type, Long lineId, String startDate, String endDate) {
        List<SysAlarmSettingEntity> settings = sysAlarmSettingDao.selectList(new EntityWrapper<SysAlarmSettingEntity>().eq("alarm_parent_type", type));
        List<Long> ids = new ArrayList<Long>();
        for(Iterator<SysAlarmSettingEntity> it = settings.iterator(); it.hasNext();){
            SysAlarmSettingEntity entity = it.next();
            ids.add(entity.getid());
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ids", ids);
        map.put("lineId", lineId);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        List<AlarmRankEntity> list = userAlarmRecordDao.waterCrossRank(map);
        List<String> dates = DateUtils.getDates(startDate, endDate);
        List<List<Integer>> datas = new ArrayList<List<Integer>>();
        List<String> names = new ArrayList<String>();
        Map<String, List<Integer>> mapping =new HashMap<String, List<Integer>>();
        for(Iterator<AlarmRankEntity> it = list.iterator(); it.hasNext(); ){
            AlarmRankEntity entity = it.next();
            String date = DateUtils.format(entity.getAlarm_time());
            dates.add(date);
            List<Integer> l = mapping.get(date);
            if(CommonUtil.isNull(l)){
                l = new ArrayList<Integer>();
                datas.add(l);
                map.put(date, l);
            }
            l.add(entity.getCounts());
            names.add(entity.getAlarm_name());
        }
        JSONObject obj = new JSONObject();
        CommonUtil.add2Json(obj, "dates", dates);
        CommonUtil.add2Json(obj, "names", names);
        CommonUtil.add2Json(obj, "datas", datas);
        return obj;
    }
    
    @Override
	public PageUtils queryByForm(Map<String, Object> params) {
		Page<UserAlarmRecordEntity> page = this.selectPage(
				new Query<UserAlarmRecordEntity>(params).getPage(),
				new EntityWrapper<UserAlarmRecordEntity>()
						.eq(getFlag(params.get("type")),"alarm_type", params.get("type"))
						.eq(getFlag(params.get("level")),"alarm_level", params.get("level"))
						.ge(getFlag(params.get("startDate")),"alarm_time", params.get("startDate"))
						.le(getFlag(params.get("endDate")),"alarm_time", params.get("endDate")));

		return new PageUtils(page);
	}
    
    public boolean getFlag(Object obj){
    	if(StringUtils.isEmpty((String)obj))
    		return false;
    	return true;
    }

}
