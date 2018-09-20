package com.zhy.modules.summary.controller;

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

import com.zhy.modules.summary.entity.SummaryYearEntity;
import com.zhy.modules.summary.service.SummaryYearService;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;



/**
 * 统计表（按天统计）
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-14 17:38:33
 */
@RestController
@RequestMapping("summary/summaryyear")
public class SummaryYearController {
    @Autowired
    private SummaryYearService summaryYearService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("summary:summaryyear:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = summaryYearService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("summary:summaryyear:info")
    public R info(@PathVariable("id") Long id){
        SummaryYearEntity summaryYear = summaryYearService.selectById(id);

        return R.ok().put("summaryYear", summaryYear);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("summary:summaryyear:save")
    public R save(@RequestBody SummaryYearEntity summaryYear){
        summaryYearService.insert(summaryYear);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("summary:summaryyear:update")
    public R update(@RequestBody SummaryYearEntity summaryYear){
        ValidatorUtils.validateEntity(summaryYear);
        summaryYearService.updateAllColumnById(summaryYear);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("summary:summaryyear:delete")
    public R delete(@RequestBody Long[] ids){
        summaryYearService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
