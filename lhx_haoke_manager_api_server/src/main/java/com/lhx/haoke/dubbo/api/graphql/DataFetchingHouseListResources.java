package com.lhx.haoke.dubbo.api.graphql;

import com.lhx.haoke.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataFetchingHouseListResources implements MyDataFecher{
    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String fieldName() {
        return "HouseResourcesList";
    }

    @Override
    public Object dataFecher(DataFetchingEnvironment environment) {
        Integer currentPage = environment.getArgument("currentPage");
        if(null == currentPage ){
            currentPage = 1;
        }
        Integer pageSize = environment.getArgument("pageSize");
        if(null == pageSize ){
            pageSize = 10;
        }
        return houseResourcesService.queryList(null,currentPage,pageSize);
    }
}
