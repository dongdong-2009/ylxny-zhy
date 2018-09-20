package com.zhy.modules.dict.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.dict.dao.ProtocolDictDao;
import com.zhy.modules.dict.entity.ProtocolDictEntity;
import com.zhy.modules.dict.service.ProtocolDictService;


@Service("protocolDictService")
public class ProtocolDictServiceImpl extends ServiceImpl<ProtocolDictDao, ProtocolDictEntity> implements ProtocolDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProtocolDictEntity> page = this.selectPage(
                new Query<ProtocolDictEntity>(params).getPage(),
                new EntityWrapper<ProtocolDictEntity>()
        );

        return new PageUtils(page);
    }

}
