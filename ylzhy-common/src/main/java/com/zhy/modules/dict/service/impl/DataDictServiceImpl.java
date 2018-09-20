package com.zhy.modules.dict.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.dict.dao.DataDictDao;
import com.zhy.modules.dict.entity.DataDictEntity;
import com.zhy.modules.dict.service.DataDictService;


@Service("dataDictService")
public class DataDictServiceImpl extends ServiceImpl<DataDictDao, DataDictEntity> implements DataDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DataDictEntity> page = this.selectPage(
                new Query<DataDictEntity>(params).getPage(),
                new EntityWrapper<DataDictEntity>()
        );

        return new PageUtils(page);
    }

}
