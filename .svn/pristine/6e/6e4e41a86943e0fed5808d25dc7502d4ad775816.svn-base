package com.zhy.modules.dict.dao;

import com.zhy.modules.dict.entity.DmDictEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 系统代码表
 * 
 * @author xtp
 * @email xtp1211@163.com
 * @date 2018-09-05 16:35:15
 */
public interface DmDictDao extends BaseMapper<DmDictEntity> {

	List<Map<String, Object>>  queryDictListByParentIdAndLxId(@Param("parentId")Long parentId, @Param("lxId")Long lxId, @Param("size")int size);
	
}
