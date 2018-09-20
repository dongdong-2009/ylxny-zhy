package com.zhy.modules.company.dao;

 
import com.zhy.modules.company.entity.CompanySbxxEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * 企业设备信息
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-14 16:56:03
 */
public interface CompanySbxxDao extends BaseMapper<CompanySbxxEntity> {

	Integer CompanyAllSbxxOnline(@Param("companyId")String companyId);

	Integer CompanyAllSbxx(@Param("companyId")String companyId);

	List<Map<String, Object>>  queryPageList(Page<Map<String, Object>> page,Map<String, Object> params);
	
}
