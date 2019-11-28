package com.lhx.haoke.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.lhx.haoke.dubbo.server.pojo.HouseResources;
import com.lhx.haoke.dubbo.server.service.HouseResoucesService;
import com.lhx.haoke.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
@Service(version = "1.0.0")
public class ApiHouseResoucesServiceImpl implements ApiHouseResoucesService{
    @Autowired
    private HouseResoucesService houseResoucesService;
    @Override
    public int saveHouseResources(HouseResources houseResources) {
        return houseResoucesService.saveHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        return houseResoucesService.queryHouseResourcesList(page,pageSize,queryCondition);
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return houseResoucesService.queryHouseResourcesById(id);
    }
}
