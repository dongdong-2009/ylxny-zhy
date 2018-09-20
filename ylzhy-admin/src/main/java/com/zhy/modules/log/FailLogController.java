package com.zhy.modules.log;

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

import com.zhy.modules.log.entity.FailLogEntity;
import com.zhy.modules.log.service.FailLogService;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;



/**
 * 采集操作失败记录
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 17:58:02
 */
@RestController
@RequestMapping("log/faillog")
public class FailLogController {
    @Autowired
    private FailLogService failLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("log:faillog:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = failLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("log:faillog:info")
    public R info(@PathVariable("id") Long id){
        FailLogEntity failLog = failLogService.selectById(id);

        return R.ok().put("failLog", failLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("log:faillog:save")
    public R save(@RequestBody FailLogEntity failLog){
        failLogService.insert(failLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("log:faillog:update")
    public R update(@RequestBody FailLogEntity failLog){
        ValidatorUtils.validateEntity(failLog);
        failLogService.updateAllColumnById(failLog);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("log:faillog:delete")
    public R delete(@RequestBody Long[] ids){
        failLogService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
