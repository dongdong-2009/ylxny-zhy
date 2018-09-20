package com.zhy.modules.summary.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.summary.entity.DataRecordEntity;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * 基础数据记录表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 14:47:25
 */
public interface DataRecordService extends IService<DataRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);

	JSONObject selectElectricCurrent();

	JSONObject selectVoltage();

	JSONObject selectPowerFactor();

	JSONObject initElectricCurrent(String startTime, String endTime);

	JSONObject initVoltage(String startTime, String endTime);

	JSONObject initPowerFactor(String startTime, String endTime);

}

