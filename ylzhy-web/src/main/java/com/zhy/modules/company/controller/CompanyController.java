package com.zhy.modules.company.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhy.modules.company.entity.CompanyEntity;
import com.zhy.modules.company.service.CompanySbxxService;
import com.zhy.modules.company.service.CompanyService;
import com.zhy.modules.qxgl.controller.AbstractController;
import com.zhy.modules.qxgl.entity.UserEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

 
import com.baomidou.mybatisplus.plugins.Page;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.R;
import com.zhy.common.validator.ValidatorUtils;



/**
 * 企业信息表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-06 10:13:31
 */
@RestController
@RequestMapping("/company/api")
@Api(tags="web首页接口")
public class CompanyController extends AbstractController{
    @Autowired
    private CompanyService companyService;
 
    /**
     * 
     * 加载公司的设备列表tree 
     * @param companyId
     * @return
     */ 
    @PostMapping("/loadSbtreelist")
    @ApiOperation(value="加载公司的设备列表树",notes="加载公司的设备列表树")
    //@RequestParam(value="companyId", required = true) String companyId
    public R  loadSbtree(){
    	  UserEntity  u=this.getUser();//通过这个可以获取到企业的基本信息，企业ID，登录人信息等
       	//  UserEntity  u1=this.getUser(true);//除了上面可以获取到的参数，还可以通过这个方法获取到企业的主回路信息， 
    	  String companyId= u.getCompanyId();//获取到公司ID
    	  
    	//  Integer MainLineId= u1.getMainLine();//主回路ID
    	//  String  MainLineName=u1.getMainLineName();//主回路名称
    	// System.err.println("MainLineId=="+MainLineId);
    	 // System.err.println("MainLineName=="+MainLineName);
    	  List<Map<String ,Object>>  comtreeList=companyService.loadCompanySbList(companyId);
    	  return R.ok().put("treeList", comtreeList);
    }
    
}
