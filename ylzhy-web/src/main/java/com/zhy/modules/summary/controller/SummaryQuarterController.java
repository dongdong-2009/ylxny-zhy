package com.zhy.modules.summary.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;
import com.zhy.common.validator.ValidatorUtils;
import com.zhy.modules.qxgl.controller.AbstractController;
import com.zhy.modules.qxgl.entity.UserEntity;
import com.zhy.modules.summary.entity.SummaryQuarterEntity;
import com.zhy.modules.summary.service.SummaryQuarterService;

import io.lettuce.core.dynamic.annotation.Value;
import net.sf.json.JSONObject;



/**
 * 
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-20 09:40:42
 */
@RestController
@RequestMapping("summary/summaryquarter")
public class SummaryQuarterController extends AbstractController{
    @Autowired
    private SummaryQuarterService summaryQuarterService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("summary:summaryquarter:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = summaryQuarterService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("summary:summaryquarter:info")
    public R info(@PathVariable("id") Long id){
        SummaryQuarterEntity summaryQuarter = summaryQuarterService.selectById(id);

        return R.ok().put("summaryQuarter", summaryQuarter);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("summary:summaryquarter:save")
    public R save(@RequestBody SummaryQuarterEntity summaryQuarter){
        summaryQuarterService.insert(summaryQuarter);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("summary:summaryquarter:update")
    public R update(@RequestBody SummaryQuarterEntity summaryQuarter){
        ValidatorUtils.validateEntity(summaryQuarter);
        summaryQuarterService.updateAllColumnById(summaryQuarter);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("summary:summaryquarter:delete")
    public R delete(@RequestBody Long[] ids){
        summaryQuarterService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 实时数据：电流
     * @param startTime
     * @param endTime
     * @param companyId
     * @param lineId
     * @return
     */
    @RequestMapping("/electricCurrent/list")
    @ResponseBody
    public R electricCurrent (@Value String startTime,@Value String endTime,@Value Integer lineId){
    	UserEntity user = this.getUser(true);
    	String companyId = user.getCompanyId();
    	if(StringUtils.isEmpty(lineId)){
    		lineId = user.getMainLine();
    	}
    	JSONObject obj  = summaryQuarterService.electricCurrent(startTime,endTime,companyId,lineId);
    	return R.ok().put("data", obj);
    }

    /**
     * 实时数据：电压
     * @param startTime
     * @param endTime
     * @param companyId
     * @param lineId
     * @return
     */
    @RequestMapping("/voltage/list")
    @ResponseBody
    public R voltage (@Value String startTime,@Value String endTime,@Value Integer lineId){
    	UserEntity user = this.getUser(true);
    	String companyId = user.getCompanyId();
    	if(StringUtils.isEmpty(lineId)){
    		lineId = user.getMainLine();
    	}
    	JSONObject obj  = summaryQuarterService.voltage(startTime,endTime,companyId,lineId);
    	return R.ok().put("data", obj);
    }

    /**
     * 实时数据：功率因数
     * @param startTime
     * @param endTime
     * @param companyId
     * @param lineId
     * @return
     */
    @RequestMapping("/powerFactor/list")
    @ResponseBody
    public R powerFactor (@Value String startTime,@Value String endTime,@Value Integer lineId){
    	UserEntity user = this.getUser(true);
    	String companyId = user.getCompanyId();
    	if(StringUtils.isEmpty(lineId)){
    		lineId = user.getMainLine();
    	}
    	JSONObject obj  = summaryQuarterService.powerFactor(startTime,endTime,companyId,lineId);
    	return R.ok().put("data", obj);
    }

}
