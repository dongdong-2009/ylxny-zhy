package com.zhy.modules.summary.service.impl;

import com.zhy.common.utils.CommonUtil;
import com.zhy.common.utils.DateUtils;
import com.zhy.modules.report.entity.FuheReportEntity;
import com.zhy.modules.report.entity.MonthPowerReportEntity;
import com.zhy.modules.summary.dao.SummaryDao;
import com.zhy.modules.summary.entity.SummaryDayEntity;
import com.zhy.modules.summary.service.SummaryDayService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.summary.dao.SummaryMonthDao;
import com.zhy.modules.summary.entity.SummaryMonthEntity;
import com.zhy.modules.summary.service.SummaryMonthService;


@Service("summaryMonthService")
public class SummaryMonthServiceImpl extends ServiceImpl<SummaryMonthDao, SummaryMonthEntity> implements SummaryMonthService {

    @Autowired
    private SummaryDao summaryDao;
    @Autowired
    private SummaryDayService summaryDayService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SummaryMonthEntity> page = this.selectPage(
                new Query<SummaryMonthEntity>(params).getPage(),
                new EntityWrapper<SummaryMonthEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public JSONObject selectMonthPower(int startMonth, int endMonth) {
        EntityWrapper<SummaryMonthEntity> w = new EntityWrapper<>();
        w.ge("month", startMonth);
        w.le("month", endMonth);
        w.orderBy("month asc");
        List<SummaryMonthEntity> list = selectList(w);
        JSONObject obj = new JSONObject();
        List<Double> month = new ArrayList<Double>();
        List<Double> datas = new ArrayList<Double>();
        List<Double> maxPowerDemand = new ArrayList<Double>();
		List<String> maxDemandTime = new ArrayList<String>();
        //int maxPower = 0;
        for(int i = 0 ; i < list.size(); i++){
            SummaryMonthEntity entity = list.get(i);
            month.add(CommonUtil.getDoubleValue(entity.getmonth()));
            datas.add(CommonUtil.getValue(entity.getmonth_power()));
            maxPowerDemand.add(CommonUtil.getValue(entity.getmonth_power()));
            maxDemandTime.add(DateUtils.getYearMonthDay(entity.getmonth_max_demand_time()));
        }
        CommonUtil.add2Json(obj, "month", month);
        CommonUtil.add2Json(obj, "datas", datas);
        CommonUtil.add2Json(obj, "maxPowerDemand", maxPowerDemand);
        CommonUtil.add2Json(obj, "maxDemandTime", maxDemandTime);
        //obj.put("maxY", maxPower);
        return obj;
    }

    @Override
    public JSONObject selectMonthFee(int startMonth, int endMonth) {
        EntityWrapper<SummaryMonthEntity> w = new EntityWrapper<>();
        w.ge("month", startMonth);
        w.le("month", endMonth);
        w.orderBy("month asc");
        List<SummaryMonthEntity> list = selectList(w);
        JSONObject obj = new JSONObject();
        List<Double> month = new ArrayList<Double>();
        List<Double> datas = new ArrayList<Double>();
        //int maxPower = 0;
        for(int i = 0 ; i < list.size(); i++){
            SummaryMonthEntity entity = list.get(i);
            month.add(CommonUtil.getDoubleValue(entity.getmonth()));
            datas.add(CommonUtil.getValue(entity.getmonth_fee()));
        }
        CommonUtil.add2Json(obj, "month", month);
        CommonUtil.add2Json(obj, "datas", datas);
        return obj;
    }

    @Override
    public List<MonthPowerReportEntity> getPowerMonthList(Map<String, Object> params, Long companyId) {
        Integer currentPage=Integer.valueOf(String.valueOf(params.get("pageNo")));
        Integer pageSize=Integer.valueOf(String.valueOf(params.get("pageSize")));
        Long stationId = Long.parseLong(CommonUtil.getString(params.get("stationId")));
        Long lineId = Long.parseLong(CommonUtil.getString(params.get("lineId")));

        List<Long> ids = summaryDao.selectLinePage(companyId, stationId, lineId, currentPage*(pageSize-1), pageSize);

        String month = DateUtils.format(new Date());
        EntityWrapper<SummaryDayEntity> w = new EntityWrapper<>();
        w.like("date", month);
        w.eq("company_id", companyId);
        w.eq("station_id", stationId);
        w.in("line_id", ids);
        List<SummaryDayEntity> l = summaryDayService.selectList(w);
        Map<Long, MonthPowerReportEntity> map = new HashMap<Long, MonthPowerReportEntity>();
        List<MonthPowerReportEntity> reports = new ArrayList<MonthPowerReportEntity>();
        for(Iterator<SummaryDayEntity> it = l.iterator(); it.hasNext();){
            SummaryDayEntity entity = it.next();
            MonthPowerReportEntity e = map.get(entity.getline_id());
            if(CommonUtil.isNull(e)){
                e = new MonthPowerReportEntity();
                e.setStationName(entity.getstation_name());
                e.setLineName(entity.getline_name());
                List<Double> list = new ArrayList<Double>();
                e.setDatas(list);
                e.setDate(DateUtils.format(entity.getdate()));
                map.put(entity.getline_id(), e);
                reports.add(e);
            }
            e.getDatas().add(CommonUtil.getValue(entity.getday_power()));
        }
        return reports;
    }

    @Override
    public List<FuheReportEntity> getFuheMonthList(Map<String, Object> params, Long companyId) {
        Long stationId = Long.parseLong(CommonUtil.getString(params.get("stationId")));
        Long lineId = Long.parseLong(CommonUtil.getString(params.get("lineId")));
        String date = CommonUtil.getString(params.get("date"));
        EntityWrapper<SummaryMonthEntity> w = new EntityWrapper<SummaryMonthEntity>();
        w.eq("company_id", companyId);
        w.eq("station_id", stationId);
        w.eq("line_id", lineId);
        w.like("date", date);
        Page<SummaryMonthEntity> page = selectPage(new Query<SummaryMonthEntity>(params).getPage(),w);
        List<FuheReportEntity> reports = new ArrayList<FuheReportEntity>();
        for(Iterator<SummaryMonthEntity> it = page.getRecords().iterator(); it.hasNext();){
            SummaryMonthEntity entity = it.next();
            FuheReportEntity e = new FuheReportEntity();
            e.setStationName(entity.getstation_name());
            e.setLineName(entity.getline_name());
            e.setMaxFuhe(entity.getmax_fuhe());
            e.setMaxFuheTime(DateUtils.format(entity.getmax_fuhe_time()));
            e.setMinFuhe(entity.getmin_fuhe());
            e.setMinFuheTime(DateUtils.format(entity.getmin_fuhe_time()));
            e.setAvgFuhe(entity.getavg_fuhe());
            e.setP_r_aprt(entity.getp_r_aprt());
            e.setP_r_rate(entity.getp_r_rate());
            e.setFuhe_rate(entity.getfuhe_rate());
            reports.add(e);
        }
        return reports;
    }

}
