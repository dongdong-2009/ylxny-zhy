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

import com.zhy.modules.dict.entity.CmdDictEntity;
import com.zhy.modules.dict.service.CmdDictService;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;



/**
 * 协议字典表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-12 15:04:39
 */
@RestController
@RequestMapping("dict/cmddict")
public class CmdDictController {
    @Autowired
    private CmdDictService cmdDictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dict:cmddict:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmdDictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dict:cmddict:info")
    public R info(@PathVariable("id") Integer id){
        CmdDictEntity cmdDict = cmdDictService.selectById(id);

        return R.ok().put("cmdDict", cmdDict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dict:cmddict:save")
    public R save(@RequestBody CmdDictEntity cmdDict){
        cmdDictService.insert(cmdDict);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dict:cmddict:update")
    public R update(@RequestBody CmdDictEntity cmdDict){
        ValidatorUtils.validateEntity(cmdDict);
        cmdDictService.updateAllColumnById(cmdDict);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dict:cmddict:delete")
    public R delete(@RequestBody Integer[] ids){
        cmdDictService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
