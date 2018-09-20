package com.zhy.modules.dict.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;
import com.zhy.common.validator.ValidatorUtils;
import com.zhy.modules.dict.entity.DmDictEntity;
import com.zhy.modules.dict.service.DmDictService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;



/**
 * 系统代码表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-05 16:35:15
 */
@RestController
@RequestMapping("dict/dmdict")
@Api(tags="字典管理")
public class DmDictController {
    @Autowired
    private DmDictService dmDictService;

 
 
    /**
     * 
     * 根据上级ID和类型ID获取到
     * 字典信息
     * parentId 
     * LxId
     * showSl
     * @param params
     * @return
     */
	@RequestMapping("/loadlist/{pid}/{lxid}/{showSl}")
	@ApiOperation(value="模糊加载DICT",notes="")
    public R listbyPIdLxId(@RequestParam Map<String, Object> params,@PathVariable("pid") Long parentId,@PathVariable("lxid") Long lxId,@PathVariable("showSl") int showSl ){
//		System.err.println("JSONObject.fromObject(params)=="+JSONObject.fromObject(params));
//		System.err.println("parentId=="+parentId);
//		System.err.println("lxId=="+lxId);
//		System.err.println("showSl=="+showSl);
        List<Map<String,Object>> dictList= dmDictService.queryDictListByParentIdAndLxId(parentId,lxId,showSl);
        return R.ok().put("page", dictList);
    }
}
