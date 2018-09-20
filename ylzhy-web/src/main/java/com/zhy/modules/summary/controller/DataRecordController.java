package com.zhy.modules.summary.controller;

import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;
import com.zhy.common.validator.ValidatorUtils;
import com.zhy.modules.qxgl.controller.AbstractController;
import com.zhy.modules.qxgl.entity.UserEntity;
import com.zhy.modules.summary.entity.DataRecordEntity;
import com.zhy.modules.summary.service.DataRecordService;

import io.lettuce.core.dynamic.annotation.Value;
import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 基础数据记录表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 14:47:25
 */
@RestController
@RequestMapping("summary/datarecord")
public class DataRecordController extends AbstractController{
    @Autowired
    private DataRecordService dataRecordService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("summary:datarecord:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dataRecordService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("summary:datarecord:info")
    public R info(@PathVariable("id") Integer id){
        DataRecordEntity dataRecord = dataRecordService.selectById(id);

        return R.ok().put("dataRecord", dataRecord);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("summary:datarecord:save")
    public R save(@RequestBody DataRecordEntity dataRecord){
        dataRecordService.insert(dataRecord);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("summary:datarecord:update")
    public R update(@RequestBody DataRecordEntity dataRecord){
        ValidatorUtils.validateEntity(dataRecord);
        dataRecordService.updateAllColumnById(dataRecord);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("summary:datarecord:delete")
    public R delete(@RequestBody Integer[] ids){
        dataRecordService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }
    
}
