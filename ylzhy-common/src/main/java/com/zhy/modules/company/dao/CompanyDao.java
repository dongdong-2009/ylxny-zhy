package com.zhy.modules.company.dao;

import com.zhy.modules.company.entity.CompanyEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 企业信息表
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-06 10:13:31
 */
public interface CompanyDao extends BaseMapper<CompanyEntity> {

	Integer CompanyAllSl(@Param("staus") String staus);

	List<Map<String, Object>> CompanyListShowInMap(@Param("comSl") int comSl, @Param("orderFiled")String orderFiled);

	List<Map<String, Object>> queryCompanyMapPageList(Page<Map<String, Object>> page,
			Map<String, Object> querycondition);

	List<Map<String, Object>> queryCompanyMapPageListLike(Page<Map<String, Object>> page,
			Map<String, Object> querycondition);

	List<Map<String, Object>> loadCompanyNameQueryInShowSize( @Param("companyName")String companyName,@Param("showSl") Integer showSl);

	List<Map<String, Object>> loadCompanySbList(@Param("companyId")String  companyId, @Param("parentId") Long parentId);

	List<Map<String, Object>> getCompanyMainLine(@Param("companyId")String  companyId);
}
