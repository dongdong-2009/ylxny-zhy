package com.zhy.modules.summary.controller;

import com.zhy.common.utils.CommonUtil;
import com.zhy.common.utils.DateUtils;
import com.zhy.modules.company.controller.CompanyController;
import com.zhy.modules.qxgl.controller.AbstractController;
import com.zhy.modules.summary.service.SummaryHourService;
import com.zhy.modules.summary.service.SummaryQuarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.common.utils.R;
import com.zhy.modules.summary.service.SummaryDayService;
import com.zhy.modules.summary.service.SummaryMonthService;

import io.lettuce.core.dynamic.annotation.Value;
import net.sf.json.JSONObject;

import java.util.Date;


@RestController
@RequestMapping("summary")
public class SummaryController extends AbstractController{
	@Autowired
	private SummaryMonthService summaryMonthService;
	
	@Autowired
	private SummaryDayService summaryDayService;

	@Autowired
	private SummaryHourService summaryHourService;
	@Autowired
	private SummaryQuarterService summaryQuarterService;

	/***
	 * 首页实时功率
	 * @return
	 */
	@RequestMapping("/realtime_gonglv/list")
	@ResponseBody
	public R realtimeGonglv(){
		String date = DateUtils.format(new Date());
		Long companyId = CommonUtil.getLong(getUser().getCompanyId());
		JSONObject obj  = summaryQuarterService.getRealTimeGonglv(date, companyId);
		System.out.println(obj);
		return R.ok().put("data", obj);
	}

	/**
	 * 分时计费
	 * @return
	 */
	@RequestMapping("/devide_fee")
	@ResponseBody
	public R devide_fee (@Value String date){
		Long companyId = CommonUtil.getLong(getUser().getCompanyId());
		JSONObject obj  = summaryDayService.getDevideFee(date, companyId);
		return R.ok().put("data", obj);
	}

	@RequestMapping("/monthPower/list")
	// @RequiresPermissions("summary:summarymonth:list")
	@ResponseBody
	public R list(@Value int startMonth, @Value int endMonth) {
		Long companyId = CommonUtil.getLong(getUser().getCompanyId());
		JSONObject obj = summaryMonthService.selectMonthPower(startMonth, endMonth);
		return R.ok().put("data", obj);
	}

	@RequestMapping("/dayPower/list")
	// @RequiresPermissions("summary:summarymonth:list")
	@ResponseBody
	public R dayPowerList(@Value String startDay, @Value String endDay) {
		JSONObject obj = summaryDayService.selectDayPower(startDay, endDay);
		return R.ok().put("data", obj);
	}

	/**
	 * 智能用电日最大需量
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	@RequestMapping("/selectPowerList/list")
	// @RequiresPermissions("summary:summarymonth:list")
	@ResponseBody
	public R selectPowerList(@Value String startDay, @Value String endDay) {
		JSONObject obj = summaryDayService.selectPowerList(startDay, endDay);
		return R.ok().put("data", obj);
	}

	@RequestMapping("/month/feeCompare")
	@ResponseBody
	public R fee(@Value int startMonth, @Value int endMonth){
		JSONObject obj  = summaryMonthService.selectMonthFee(startMonth, endMonth);
		return R.ok().put("data", obj);
	}

	/**
	 * 首页最大需量
	 * @return
	 */
	@RequestMapping("/maximumDemand/list")
	@ResponseBody
	public R maximumDemand (@Value String nowDay,@Value String upMonth){
		JSONObject obj  = summaryDayService.maximumDemand(nowDay,upMonth);
		return R.ok().put("data", obj);
	}

	/**
	 * 最大负荷
	 * @return
	 */
	@RequestMapping("/maxFuhe")
	@ResponseBody
	public R maxFuhe (@Value String date){
		JSONObject obj  = summaryHourService.getMaxFuhe(date);
		return R.ok().put("data", obj);
	}
	
	/**
	 * 能耗时比
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	@RequestMapping("/hour/list")
	// @RequiresPermissions("summary:summarymonth:list")
	@ResponseBody
	public R maxFuheFull(@Value String startDay, @Value String endDay) {
		JSONObject obj = summaryHourService.selectMaxFuheFull(startDay, endDay);
		return R.ok().put("data", obj);
	}
	
	/**
	 * 能耗类比
	 * @param startDay
	 * @param endDay
	 * @return
	 */
	@RequestMapping("/energyConsumptionAnalogy/list")
	// @RequiresPermissions("summary:summarymonth:list")
	@ResponseBody
	public R energyConsumptionAnalogy(@Value String startDay, @Value String endDay) {
		JSONObject obj = summaryHourService.energyConsumptionAnalogy(startDay, endDay);
		return R.ok().put("data", obj);
	}


	/**
	 * 能效排名
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	@RequestMapping("/powerRank/list")
	// @RequiresPermissions("summary:summarymonth:list")
	@ResponseBody
	public R energeRanks(@Value Long companyId, @Value String startDate, @Value String endDate) {
		JSONObject obj = summaryDayService.energeRanks(companyId, startDate, endDate);
		System.out.print(obj);
		return R.ok().put("data", obj);
	}


}
