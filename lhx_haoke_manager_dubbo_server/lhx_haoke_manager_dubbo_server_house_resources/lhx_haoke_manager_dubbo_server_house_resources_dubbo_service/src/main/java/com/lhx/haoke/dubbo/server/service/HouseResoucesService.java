package com.lhx.haoke.dubbo.server.service;

import com.lhx.haoke.dubbo.server.pojo.HouseResources;
import com.lhx.haoke.dubbo.server.vo.PageInfo;

public interface HouseResoucesService {
    int saveHouseResources(HouseResources houseResources);//-1参数不符合要求0数据库插入失败1成功

    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);

    HouseResources queryHouseResourcesById(Long id);
}
