package com.zhy.modules.summary.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.report.entity.FuheReportEntity;
import com.zhy.modules.report.entity.MonthPowerReportEntity;
import com.zhy.modules.summary.entity.SummaryMonthEntity;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * 统计表（按天统计）
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-14 17:38:33
 */
public interface SummaryMonthService extends IService<SummaryMonthEntity> {

    PageUtils queryPage(Map<String, Object> params);

    JSONObject selectMonthPower(int startMonth, int endMonth);

    JSONObject selectMonthFee(int startMonth, int endMonth);

    List<MonthPowerReportEntity> getPowerMonthList(Map<String, Object> map, Long companyId);

    List<FuheReportEntity> getFuheMonthList(Map<String, Object> params, Long companyId);
}

