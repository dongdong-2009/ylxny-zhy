package com.zhy.modules.dict.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhy.common.utils.PageUtils;
import com.zhy.common.utils.Query;

import com.zhy.modules.dict.dao.DeviceDao;
import com.zhy.modules.dict.entity.DeviceEntity;
import com.zhy.modules.dict.service.DeviceService;


@Service("deviceService")
public class DeviceServiceImpl extends ServiceImpl<DeviceDao, DeviceEntity> implements DeviceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DeviceEntity> page = this.selectPage(
                new Query<DeviceEntity>(params).getPage(),
                new EntityWrapper<DeviceEntity>()
        );

        return new PageUtils(page);
    }

}
