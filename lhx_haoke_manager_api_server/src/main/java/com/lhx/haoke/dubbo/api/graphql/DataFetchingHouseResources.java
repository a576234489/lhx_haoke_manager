package com.lhx.haoke.dubbo.api.graphql;

import com.lhx.haoke.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataFetchingHouseResources implements MyDataFecher{
    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public String fieldName() {
        return "HouseResources";
    }

    @Override
    public Object dataFecher(DataFetchingEnvironment environment) {
        Long id = environment.getArgument("id");
        return houseResourcesService.queryHouseResourcesById(id);
    }
}
