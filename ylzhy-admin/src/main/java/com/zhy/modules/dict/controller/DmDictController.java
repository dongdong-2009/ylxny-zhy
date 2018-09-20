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

import com.zhy.common.annotation.SysLog;
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
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("dict:dmdict:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = dmDictService.queryPage(params);

        return R.ok().put("page", page);
    }
    
    /**
     * 列表
     */
    @RequestMapping("/list/{lxId}")
    @RequiresPermissions("dict:dmdict:list")
    public R selectByLxid(@PathVariable("lxId") Integer lxId,@RequestParam Map<String, Object> params){
    	PageUtils page = dmDictService.queryPage(lxId,params);
    	
    	return R.ok().put("page", page);
    }
    
    /**
     * 信息(点击修改，数据回显)
     */
    @RequestMapping("/info/{lxId}")
    @RequiresPermissions("dict:dmdictlx:info")
    public R info(@PathVariable("lxId") Long lxId){
        DmDictEntity dmDict = dmDictService.selectById(lxId);

        return R.ok().put("dmDict", dmDict);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{lxId}/{zdid}")
    @RequiresPermissions("dict:dmdict:list")
    public R selectByLxid(@PathVariable("lxId") Integer lxId,@PathVariable("zdid") Integer zdid,@RequestParam Map<String, Object> params){
    	if(zdid==-1){
    		PageUtils page = dmDictService.queryPage(lxId,params);
    		return R.ok().put("page", page);
    	}else{
    		PageUtils page = dmDictService.queryPage(lxId,zdid,params);
    		return R.ok().put("page", page);
    	}
    }
    /**
     * 保存
     */
    @SysLog("添加字典")
    @RequestMapping("/save")
    @RequiresPermissions("dict:dmdict:save")
    public R save(@RequestBody DmDictEntity dmDict){
        dmDictService.insert(dmDict);

        return R.ok();
    }

    /**
     * 修改
     */
    @SysLog("修改字典")
    @RequestMapping("/update")
    @RequiresPermissions("dict:dmdict:update")
    public R update(@RequestBody DmDictEntity dmDict){
        ValidatorUtils.validateEntity(dmDict);
        dmDictService.updateAllColumnById(dmDict);//全部更新
        
        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除字典")
    @RequestMapping("/delete")
    @RequiresPermissions("dict:dmdict:delete")
    public R delete(@RequestBody Long[] zdids){
        dmDictService.deleteBatchIds(Arrays.asList(zdids));

        return R.ok();
    }
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
