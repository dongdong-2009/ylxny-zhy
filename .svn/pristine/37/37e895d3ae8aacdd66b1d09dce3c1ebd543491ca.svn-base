package com.zhy.modules.report.controller;

import com.zhy.common.utils.DateUtils;
import com.zhy.common.utils.R;
import com.zhy.modules.qxgl.controller.AbstractController;
import com.zhy.modules.report.entity.*;
import com.zhy.modules.summary.service.SummaryDayService;
import com.zhy.modules.summary.service.SummaryMonthService;
import com.zhy.modules.summary.service.SummaryYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Package com.zhy.modules.report
 * @Description:
 * @User: zengqiang
 * @Date: 2018-09-19
 */
@RestController
@RequestMapping("report")
public class ReportController extends AbstractController{
    @Autowired
    private SummaryDayService summaryDayService;
    @Autowired
    private SummaryMonthService summaryMonthService;
    @Autowired
    private SummaryYearService summaryYearService;

    @RequestMapping("/power/dayList")
    @ResponseBody
    public R powerDayList(@RequestParam Map<String, Object> params) {
        String today = DateUtils.format(new Date());
        Long companyId = Long.parseLong(getUser().getCompanyId());
        List<DayPowerReportEntity> list = summaryDayService.getPowerDayList(params, today, companyId);
        return R.ok().put("data", list);
    }

    @RequestMapping("/power/monthList")
    @ResponseBody
    public R powerMonthList(@RequestParam Map<String, Object> params) {
        Long companyId = Long.parseLong(getUser().getCompanyId());
        List<MonthPowerReportEntity> list = summaryMonthService.getPowerMonthList(params, companyId);
        return R.ok().put("data", list);
    }

    @RequestMapping("/power/yearList")
    @ResponseBody
    public R powerYearList(@RequestParam Map<String, Object> params) {
        Long companyId = Long.parseLong(getUser().getCompanyId());
        List<YearPowerReportEntity> list = summaryYearService.getPowerYearList(params, companyId);
        return R.ok().put("data", list);
    }

    @RequestMapping("/fuhe/dayList")
    @ResponseBody
    public R fuheDayList(@RequestParam Map<String, Object> params) {
        Long companyId = Long.parseLong(getUser().getCompanyId());
        List<FuheReportEntity> list = summaryDayService.getFuheDayList(params, companyId);
        return R.ok().put("data", list);
    }

    @RequestMapping("/fuhe/monthList")
    @ResponseBody
    public R fuheMonthList(@RequestParam Map<String, Object> params) {
        Long companyId = Long.parseLong(getUser().getCompanyId());
        List<FuheReportEntity> list = summaryMonthService.getFuheMonthList(params, companyId);
        return R.ok().put("data", list);
    }

    @RequestMapping("/fuhe/yearList")
    @ResponseBody
    public R fuheYearList(@RequestParam Map<String, Object> params) {
        Long companyId = Long.parseLong(getUser().getCompanyId());
        List<FuheReportEntity> list = summaryYearService.getFuheYearList(params, companyId);
        return R.ok().put("data", list);
    }
}