package com.zhy.controller;

import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.annotation.Login;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;
import com.zhy.common.validator.ValidatorUtils;
import com.zhy.modules.dict.entity.DmDictEntity;
import com.zhy.modules.dict.service.DmDictService;
import com.zhy.modules.qxgl.entity.UserEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



/**
 * 字典表维护
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-05 16:35:15
 */
@RestController
@RequestMapping("/api")
@Api(tags="字典维护")
public class DmDictController {
    @Autowired
    private DmDictService dmDictService;

    /**
     * 根据类型获取字典列表
     */
    @Login
    @GetMapping("/list/{lxId}")
    @ApiOperation(value="根据类型获取字典列表",notes="需要参数:类型ID和token(必传),传递方式:在路径后拼接即可(示例:XXX/list/类型ID)")
    public R selectByLxid(@PathVariable("lxId") Integer lxId){
    	Map<String, Object> map = dmDictService.queryPage(lxId);
    	
    	return R.ok().put("map", map);
    }

    /**
     * 根据类型和父类型获取字典列表
     */
    @Login
    @GetMapping("/list/{lxId}/{zdid}")
    @ApiOperation(value="根据类型和父类型获取字典列表",notes="需要参数:类型ID,父ID(当前地址上一级的id)和token(必传),传递方式:在路径后拼接即可(示例:XXX/list/类型ID/父ID)")
	public R selectByLxid(@PathVariable("lxId") Integer lxId, @PathVariable("zdid") Integer zdid) {
		Map<String, Object> map = dmDictService.queryPage(lxId,zdid);

		return R.ok().put("map", map);
    }
    
     



}
