package com.zhy.modules.company.service.impl;

import java.util.List;
import java.util.Map;
 
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;
import com.zhy.modules.company.dao.CompanySbxxDao;
import com.zhy.modules.company.entity.CompanySbxxEntity;
import com.zhy.modules.company.service.CompanySbxxService;


@Service("companySbxxService")
public class CompanySbxxServiceImpl extends ServiceImpl<CompanySbxxDao, CompanySbxxEntity> implements CompanySbxxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CompanySbxxEntity> page = this.selectPage(
                new Query<CompanySbxxEntity>(params).getPage(),
                new EntityWrapper<CompanySbxxEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public Integer CompanyAllSbxx(String companyId) {
		// TODO Auto-generated method stub
		return this.baseMapper.CompanyAllSbxx(companyId);
	}
    /**
     * 
     * 获取到在线设备数量
     */
	@Override
	public Integer CompanyAllSbxxOnline(String companyId) {
		// TODO Auto-generated method stub
		return 2;
		//return this.baseMapper.CompanyAllSbxxOnline(companyId);
	}
    /**
     * 
     * 根据条件查询 设备信息
     */
	@Override
	public PageUtils queryPageList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		Integer currentPage=Integer.valueOf(String.valueOf(params.get("page")));
		Integer pageSize=Integer.valueOf(String.valueOf(params.get("limit")));
		Page<Map<String, Object>> page = new Page<Map<String, Object>>(currentPage,pageSize);
	 
		 List<Map<String, Object>> pageList= baseMapper.queryPageList(page,params);
         
		 page.setRecords(pageList);
		 page.setTotal(pageList.size());
		  
			//System.err.println(pageList.toString());
		 PageUtils p=new PageUtils(pageList,page.getTotal(),pageSize,currentPage);
		 return p;
	}

}
