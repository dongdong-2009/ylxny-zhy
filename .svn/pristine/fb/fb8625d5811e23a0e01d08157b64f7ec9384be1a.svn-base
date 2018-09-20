package com.zhy.modules.alarm.controller;

import java.util.Arrays;
import java.util.Map;

import com.zhy.common.validator.ValidatorUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.modules.alarm.entity.SysAlarmSettingEntity;
import com.zhy.modules.alarm.service.SysAlarmSettingService;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;



/**
 * 报警设置
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-17 13:57:52
 */
@RestController
@RequestMapping("alarm/sysalarmsetting")
public class SysAlarmSettingController {
    @Autowired
    private SysAlarmSettingService sysAlarmSettingService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("alarm:sysalarmsetting:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysAlarmSettingService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("alarm:sysalarmsetting:info")
    public R info(@PathVariable("id") Long id){
        SysAlarmSettingEntity sysAlarmSetting = sysAlarmSettingService.selectById(id);

        return R.ok().put("sysAlarmSetting", sysAlarmSetting);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("alarm:sysalarmsetting:save")
    public R save(@RequestBody SysAlarmSettingEntity sysAlarmSetting){
        sysAlarmSettingService.insert(sysAlarmSetting);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("alarm:sysalarmsetting:update")
    public R update(@RequestBody SysAlarmSettingEntity sysAlarmSetting){
        ValidatorUtils.validateEntity(sysAlarmSetting);
        sysAlarmSettingService.updateAllColumnById(sysAlarmSetting);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("alarm:sysalarmsetting:delete")
    public R delete(@RequestBody Long[] ids){
        sysAlarmSettingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
