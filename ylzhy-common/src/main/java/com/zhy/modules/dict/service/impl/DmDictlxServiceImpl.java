package com.zhy.modules.dict.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;
import com.zhy.modules.dict.dao.DmDictlxDao;
import com.zhy.modules.dict.entity.DmDictlxEntity;
import com.zhy.modules.dict.service.DmDictlxService;


@Service("dmDictlxService")
public class DmDictlxServiceImpl extends ServiceImpl<DmDictlxDao, DmDictlxEntity> implements DmDictlxService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DmDictlxEntity> page = this.selectPage(
                new Query<DmDictlxEntity>(params).getPage(),
                new EntityWrapper<DmDictlxEntity>()
        );

        return new PageUtils(page);
    }

}
