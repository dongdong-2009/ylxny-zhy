package com.zhy.modules.company.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;
import com.zhy.modules.company.dao.CompanyDao;
import com.zhy.modules.company.entity.CompanyEntity;
import com.zhy.modules.company.service.CompanyService;
import com.zhy.modules.qxgl.entity.UserEntity;
import com.zhy.modules.qxgl.service.UserService;


@Service("companyService")
public class CompanyServiceImpl extends ServiceImpl<CompanyDao, CompanyEntity> implements CompanyService {
	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private UserService  userService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        
        Page<CompanyEntity> page = this.selectPage(
                new Query<CompanyEntity>(params).getPage(),
                new EntityWrapper<CompanyEntity>().like("companyname", String.valueOf(params.get("Companyname")))
        );

        return new PageUtils(page);
    }

	@Override
	public  Map<String, Object>  queryCompanyMapPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer currentPage=Integer.valueOf(String.valueOf(params.get("pageNo")));
		Integer pageSize=Integer.valueOf(String.valueOf(params.get("pageSize")));
		Page<Map<String, Object>> page = new Page<Map<String, Object>>(currentPage,pageSize);
		Map<String, Object> querycondition=new HashMap<String, Object>();
		List<Map<String, Object>> comList=null;
		if(StringUtils.checkValNotNull(params.get("companyId"))){
			querycondition.put("companyId", String.valueOf(params.get("companyId")));
			comList= companyDao.queryCompanyMapPageList(page,querycondition);
		}else{
			querycondition.put("queryString", String.valueOf(params.get("queryString")));
			 
			 comList = companyDao.queryCompanyMapPageListLike(page,querycondition);
		}
		page.setRecords(comList);
		params.put("page", page);
//		  System.err.println("getTotal==="+page.getTotal()); //获取到总条数
//		  System.err.println("getSize==="+page.getSize()); //每一页的条数
//		  System.err.println("getPages==="+page.getPages());// 总页数
//		  System.err.println("getCondition==="+page.getCondition()); 
		 
		return params;
	}

  


	/**
	 * 
	 * 根据状态获取到公司的数量和在线状态
	 */
	public Integer CompanyAllSl(String staus) {
		// TODO Auto-generated method stub
		return baseMapper.CompanyAllSl(staus);
	}

	@Override
	public List<Map<String, Object>> CompanyListShowInMap(int comSl, String orderFiled) {
		// TODO Auto-generated method stub
		return baseMapper.CompanyListShowInMap(comSl,orderFiled);
	}

	@Override
	public PageUtils initList(Map<String, Object> params) {
		 Page<CompanyEntity> page = this.selectPage(
	                new Query<CompanyEntity>(params).getPage(),
	                new EntityWrapper<CompanyEntity>()
	        );

	        return new PageUtils(page);
	}

	@Override
	public CompanyEntity selectById(String companyid, Map<String, Object> params) {
		return companyDao.selectById(companyid);
	}

	@Override
	public PageUtils selectList(String companyname, Map<String, Object> params) {
		if("all".equals(companyname)){
			Page<CompanyEntity> page = this.selectPage(
	                new Query<CompanyEntity>(params).getPage()
	        );

	        return new PageUtils(page);
		}else {
			Page<CompanyEntity> page = this.selectPage(
	                new Query<CompanyEntity>(params).getPage(),
	                new EntityWrapper<CompanyEntity>().like("companyname", companyname)
	        );

	        return new PageUtils(page);
		}
		 
	}

	@Override
	public PageUtils selectPages(Map<String, Object> params) {
		Page<CompanyEntity> page = this.selectPage(
                new Query<CompanyEntity>(params).getPage()
        );

        return new PageUtils(page);
	}

	@Override
	public PageUtils queryBynameOrAddress(String value, Map<String, Object> params) {
		Page<CompanyEntity> page = this.selectPage(
                new Query<CompanyEntity>(params).getPage(),
                new EntityWrapper<CompanyEntity>().like("companyname", value).or().like("address",value)
        );

        return new PageUtils(page);
	}

	@Override
	public void createWebUser(CompanyEntity company) {
		// TODO Auto-generated method stub
		Date createtime=new Date();
		company.setCreatetime(createtime);
		this.baseMapper.insert(company);
		UserEntity newUser=new UserEntity();
		newUser.setCompanyId(company.getCompanyid());
		newUser.setCreateTime(createtime);
	//	newUser.setMobile(company.getMobile());
		newUser.setXybz("Y");
		String salt = RandomStringUtils.randomAlphanumeric(20);
		newUser.setSalt(salt);
		//String password=company.getMobile().substring(3,9);
		//newUser.setPassword(ShiroUtils.sha256(password, newUser.getSalt()));
		//newUser.setPassword(password);
		//newUser.setSalt(salt);
	//	newUser.setUsername(company.getMobile());
		userService.insert(newUser);
	}

	/**
	 * 
	 * 根据公司名称模糊加载公司List并选择
	 */
	public List<Map<String, Object>> loadCompanyNameQueryInShowSize(String companyName, Integer showSl) {
		// TODO Auto-generated method stub
		return this.baseMapper.loadCompanyNameQueryInShowSize(companyName, showSl);
	}

    /**
     * 
     * 加载公司设备的treeList
     * 
     */
	public List<Map<String, Object>> loadCompanySbList(String companyId) {
		// TODO Auto-generated method stub
		   List<Map<String, Object>> list=  this.baseMapper.loadCompanySbList(companyId,0L);//获取到第一级的设备
		   this.getSonSbList(companyId,list);
		  return  list;
	}
	/**
	 * 
	 * 得到
	 * @param CompanySbList
	 * @return
	 */
    public  List<Map<String, Object>> getSonSbList(String companyId, List<Map<String, Object>> companySbList){
    	
    	for(Map<String, Object> sbmap:companySbList){
    		Long sbId =Long.valueOf(String.valueOf(sbmap.get("id")));
    	    List<Map<String, Object>> list=  this.baseMapper.loadCompanySbList(companyId,sbId);//获取到当前设备的下级设备
    	    sbmap.put("children", list);
    	}
    	
    	return companySbList;
    }

	/**
	 * 
	 * 获取到企业的主回路
	 */
	public Map<String, Object> getCompanyMainLine(String companyId) {
		// TODO Auto-generated method stub
	    List<Map<String, Object>> list=  this.baseMapper.getCompanyMainLine(companyId);//获取到第一级的设备
		return list.get(0);
	}
}
