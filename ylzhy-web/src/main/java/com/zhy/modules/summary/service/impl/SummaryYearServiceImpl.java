package com.zhy.modules.summary.service.impl;

import com.zhy.common.utils.CommonUtil;
import com.zhy.common.utils.DateUtils;
import com.zhy.modules.report.entity.FuheReportEntity;
import com.zhy.modules.report.entity.YearPowerReportEntity;
import com.zhy.modules.summary.dao.SummaryDao;
import com.zhy.modules.summary.entity.SummaryMonthEntity;
import com.zhy.modules.summary.service.SummaryMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.summary.dao.SummaryYearDao;
import com.zhy.modules.summary.entity.SummaryYearEntity;
import com.zhy.modules.summary.service.SummaryYearService;


@Service("summaryYearService")
public class SummaryYearServiceImpl extends ServiceImpl<SummaryYearDao, SummaryYearEntity> implements SummaryYearService {
    @Autowired
    private SummaryDao summaryDao;
    @Autowired
    private SummaryMonthService summaryMonthService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SummaryYearEntity> page = this.selectPage(
                new Query<SummaryYearEntity>(params).getPage(),
                new EntityWrapper<SummaryYearEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<YearPowerReportEntity> getPowerYearList(Map<String, Object> params, Long companyId) {
        Integer currentPage=Integer.valueOf(String.valueOf(params.get("pageNo")));
        Integer pageSize=Integer.valueOf(String.valueOf(params.get("pageSize")));
        Long stationId = Long.parseLong(CommonUtil.getString(params.get("stationId")));
        Long lineId = Long.parseLong(CommonUtil.getString(params.get("lineId")));

        List<Long> ids = summaryDao.selectLinePage(companyId, stationId, lineId, currentPage*(pageSize-1), pageSize);

        String month = DateUtils.format(new Date());
        EntityWrapper<SummaryMonthEntity> w = new EntityWrapper<>();
        w.like("date", month);
        w.eq("company_id", companyId);
        w.eq("station_id", stationId);
        w.in("line_id", ids);
        List<SummaryMonthEntity> l = summaryMonthService.selectList(w);
        Map<Long, YearPowerReportEntity> map = new HashMap<Long, YearPowerReportEntity>();
        List<YearPowerReportEntity> reports = new ArrayList<YearPowerReportEntity>();
        for(Iterator<SummaryMonthEntity> it = l.iterator(); it.hasNext();){
            SummaryMonthEntity entity = it.next();
            YearPowerReportEntity e = map.get(entity.getline_id());
            if(CommonUtil.isNull(e)){
                e = new YearPowerReportEntity();
                e.setStationName(entity.getstation_name());
                e.setLineName(entity.getline_name());
                List<Double> list = new ArrayList<Double>();
                e.setDatas(list);
                e.setMonth(CommonUtil.getString(entity.getmonth()));
                map.put(entity.getline_id(), e);
                reports.add(e);
            }
            e.getDatas().add(CommonUtil.getValue(entity.getmonth_power()));
        }
        return reports;
    }

    @Override
    public List<FuheReportEntity> getFuheYearList(Map<String, Object> params, Long companyId) {
        Long stationId = Long.parseLong(CommonUtil.getString(params.get("stationId")));
        Long lineId = Long.parseLong(CommonUtil.getString(params.get("lineId")));
        EntityWrapper<SummaryYearEntity> w = new EntityWrapper<SummaryYearEntity>();
        w.eq("company_id", companyId);
        w.eq("station_id", stationId);
        w.eq("line_id", lineId);
        Page<SummaryYearEntity> page = selectPage(new Query<SummaryYearEntity>(params).getPage(),w);
        List<FuheReportEntity> reports = new ArrayList<FuheReportEntity>();
        for(Iterator<SummaryYearEntity> it = page.getRecords().iterator(); it.hasNext();){
            SummaryYearEntity entity = it.next();
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
