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

import com.zhy.modules.dict.entity.ProtocolDictEntity;
import com.zhy.modules.dict.service.ProtocolDictService;
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
@RequestMapping("dict/protocoldict")
public class ProtocolDictController {
    @Autowired
    private ProtocolDictService protocolDictService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dict:protocoldict:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = protocolDictService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("dict:protocoldict:info")
    public R info(@PathVariable("id") Long id){
        ProtocolDictEntity protocolDict = protocolDictService.selectById(id);

        return R.ok().put("protocolDict", protocolDict);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("dict:protocoldict:save")
    public R save(@RequestBody ProtocolDictEntity protocolDict){
        protocolDictService.insert(protocolDict);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("dict:protocoldict:update")
    public R update(@RequestBody ProtocolDictEntity protocolDict){
        ValidatorUtils.validateEntity(protocolDict);
        protocolDictService.updateAllColumnById(protocolDict);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("dict:protocoldict:delete")
    public R delete(@RequestBody Long[] ids){
        protocolDictService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }

}
