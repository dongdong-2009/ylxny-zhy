package com.zhy.modules.dict.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.dict.dao.CmdDictDao;
import com.zhy.modules.dict.entity.CmdDictEntity;
import com.zhy.modules.dict.service.CmdDictService;


@Service("cmdDictService")
public class CmdDictServiceImpl extends ServiceImpl<CmdDictDao, CmdDictEntity> implements CmdDictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CmdDictEntity> page = this.selectPage(
                new Query<CmdDictEntity>(params).getPage(),
                new EntityWrapper<CmdDictEntity>()
        );

        return new PageUtils(page);
    }

}
