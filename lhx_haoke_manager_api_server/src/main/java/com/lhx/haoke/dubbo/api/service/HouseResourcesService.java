package com.lhx.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lhx.haoke.dubbo.api.vo.Pagination;
import com.lhx.haoke.dubbo.api.vo.TableResult;
import com.lhx.haoke.dubbo.server.api.ApiHouseResoucesService;
import com.lhx.haoke.dubbo.server.pojo.HouseResources;

import com.lhx.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;


@Service
public class HouseResourcesService {
    @Reference(version = "1.0.0")
    private ApiHouseResoucesService apiHouseResoucesService;

    public boolean save(HouseResources houseResources){
        int i = apiHouseResoucesService.saveHouseResources(houseResources);

        return i == 1;
    }

    public TableResult queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
        PageInfo<HouseResources> houseResourcesPageInfo = apiHouseResoucesService.queryHouseResourcesList(currentPage, pageSize, houseResources);
        return new TableResult(houseResourcesPageInfo.getRecords(),new Pagination(currentPage,pageSize,houseResourcesPageInfo.getTotal()));
    }

    public HouseResources queryHouseResourcesById(long id){
        return apiHouseResoucesService.queryHouseResourcesById(id);
    }
}
