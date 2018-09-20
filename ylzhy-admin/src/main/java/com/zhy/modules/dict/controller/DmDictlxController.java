package com.zhy.modules.dict.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.common.annotation.SysLog;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;
import com.zhy.common.validator.ValidatorUtils;
import com.zhy.datasources.annotation.DataSource;
import com.zhy.modules.dict.entity.DmDictlxEntity;
import com.zhy.modules.dict.service.DmDictlxService;



/**
 * 代码类型表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-05 16:27:51
 */
@RestController
@RequestMapping("dict/dmdictlx")
public class DmDictlxController {
    @Autowired
    private DmDictlxService dmDictlxService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dict:dmdictlx:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dmDictlxService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息(点击修改，数据回显)
     */
    @RequestMapping("/info/{lxId}")
    @RequiresPermissions("dict:dmdictlx:info")
    public R info(@PathVariable("lxId") Long lxId){
        DmDictlxEntity dmDictlx = dmDictlxService.selectById(lxId);

        return R.ok().put("dmDictlx", dmDictlx);
    }

    /**
     * 保存
     */
    //@DataSource(name="second") 配置数据源
    @SysLog("添加字典类型")
    @RequestMapping("/save")
    @RequiresPermissions("dict:dmdictlx:save")
    public R save(@RequestBody DmDictlxEntity dmDictlx){
        dmDictlxService.insert(dmDictlx);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改字典类型")
    @RequestMapping("/update")
    @RequiresPermissions("dict:dmdictlx:update")
    public R update(@RequestBody DmDictlxEntity dmDictlx){
        ValidatorUtils.validateEntity(dmDictlx);
        dmDictlxService.updateAllColumnById(dmDictlx);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除字典类型")
    @RequestMapping("/delete")
    @RequiresPermissions("dict:dmdictlx:delete")
    public R delete(@RequestBody Long[] lxIds){
        dmDictlxService.deleteBatchIds(Arrays.asList(lxIds));

        return R.ok();
    }

}
