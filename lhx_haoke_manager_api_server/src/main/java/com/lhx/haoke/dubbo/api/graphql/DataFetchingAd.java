package com.lhx.haoke.dubbo.api.graphql;

import com.lhx.haoke.dubbo.api.service.AdService;
import com.lhx.haoke.dubbo.api.service.HouseResourcesService;
import com.lhx.haoke.dubbo.api.vo.WebResult;
import com.lhx.haoke.dubbo.api.vo.ad.index.IndexAdResult;
import com.lhx.haoke.dubbo.api.vo.ad.index.IndexAdResultData;
import com.lhx.haoke.dubbo.server.pojo.Ad;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataFetchingAd implements MyDataFecher{
    @Autowired
    private AdService adServicea;

    @Override
    public String fieldName() {
        return "IndexAdResult";
    }

    @Override
    public Object dataFecher(DataFetchingEnvironment environment) {
        WebResult webResult = adServicea.queryAdList(1, 3, 1);
        List<IndexAdResultData> list = new ArrayList<>();
        for (Object o :  webResult.getList()) {
            Map<String,Object> ad = (Map<String,Object>)o;
            list.add(new IndexAdResultData(ad.get("origianl").toString()));
        }
        return new IndexAdResult(list);
    }
}
