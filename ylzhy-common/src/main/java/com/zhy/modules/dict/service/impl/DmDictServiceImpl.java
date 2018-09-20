package com.zhy.modules.dict.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;
import com.zhy.modules.dict.dao.DmDictDao;
import com.zhy.modules.dict.entity.DmDictEntity;
import com.zhy.modules.dict.service.DmDictService;


@Service("dmDictService")
public class DmDictServiceImpl extends ServiceImpl<DmDictDao, DmDictEntity> implements DmDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DmDictEntity> page = this.selectPage(
                new Query<DmDictEntity>(params).getPage(),
                new EntityWrapper<DmDictEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils queryPage(Integer lxId, Map<String, Object> params) {
		 Page<DmDictEntity> page = this.selectPage(
	                new Query<DmDictEntity>(params).getPage(),
	                	new EntityWrapper<DmDictEntity>().eq("lxid",lxId)
	        );

	        return new PageUtils(page);
	}

	@Override
	public PageUtils queryPage(Integer lxId, Integer zdid, Map<String, Object> params) {
		Page<DmDictEntity> page = this.selectPage(
				new Query<DmDictEntity>(params).getPage(),
				new EntityWrapper<DmDictEntity>().eq("lxid",lxId).eq("parentid",zdid)
				);
		
		return new PageUtils(page);
	}

	@Override
	public Map<String, Object> queryPage(Integer lxId) {
		Map<String, Object> map = this.selectMap(
            	new EntityWrapper<DmDictEntity>().eq("lxid",lxId)
    );
		return map;
	}

	@Override
	public Map<String, Object> queryPage(Integer lxId, Integer zdid) {
		Map<String, Object> map = this.selectMap(
            	new EntityWrapper<DmDictEntity>().eq("lxid",lxId).eq("zdid", zdid)
    );
		return map;
	}

	/**
	 * 根据上级ID或和类型ID获取到字典list，名称，zdcode，zdId 三项
	 */
	public List<Map<String, Object>> queryDictListByParentIdAndLxId(Long parentId, Long lxId, int size) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> dictList= this.baseMapper.queryDictListByParentIdAndLxId(parentId,lxId,size);
		return dictList;
	}
}
