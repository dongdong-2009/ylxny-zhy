package com.zhy.modules.dict.controller;

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

import com.zhy.modules.dict.entity.DeviceEntity;
import com.zhy.modules.dict.service.DeviceService;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;



/**
 * 
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 15:04:39
 */
@RestController
@RequestMapping("dict/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dict:device:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = deviceService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dict:device:info")
    public R info(@PathVariable("id") Integer id){
        DeviceEntity device = deviceService.selectById(id);

        return R.ok().put("device", device);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dict:device:save")
    public R save(@RequestBody DeviceEntity device){
        deviceService.insert(device);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dict:device:update")
    public R update(@RequestBody DeviceEntity device){
        ValidatorUtils.validateEntity(device);
        deviceService.updateAllColumnById(device);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dict:device:delete")
    public R delete(@RequestBody Integer[] ids){
        deviceService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
