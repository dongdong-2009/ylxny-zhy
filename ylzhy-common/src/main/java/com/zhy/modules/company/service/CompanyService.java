package com.zhy.modules.company.service;

import com.baomidou.mybatisplus.service.IService;
import com.zhy.common.utils.PageUtils;
import com.zhy.modules.company.entity.CompanyEntity;
import com.zhy.modules.company.entity.CompanySbxxEntity;

import java.util.List;
import java.util.Map;

/**
 * 企业信息表
 *
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-06 10:13:31
 */
public interface CompanyService extends IService<CompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);

	Integer CompanyAllSl(String staus);

	List<Map<String, Object>> CompanyListShowInMap(int comSl, String orderFiled);

	PageUtils initList(Map<String, Object> params);

	CompanyEntity selectById(String companyid, Map<String, Object> params);

	PageUtils selectList(String companyname, Map<String, Object> params);

	PageUtils selectPages(Map<String, Object> params);

	PageUtils queryBynameOrAddress(String value, Map<String, Object> params);

	//PageUtils selectByCompanyId(String companyid);
	void createWebUser(CompanyEntity company);

	 Map<String, Object>   queryCompanyMapPageList(Map<String, Object> params);

	List<Map<String, Object>> loadCompanyNameQueryInShowSize(String companyName, Integer showSl);

	List<Map<String, Object>> loadCompanySbList(String companyId);

	Map<String, Object> getCompanyMainLine(String companyId);

}
