package com.lhx.haoke.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lhx.haoke.dubbo.api.vo.WebResult;
import com.lhx.haoke.dubbo.server.api.ApiAdService;
import com.lhx.haoke.dubbo.server.pojo.Ad;
import com.lhx.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AdService {
    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    public WebResult queryAdList(int page, int pageSize, int type){
        PageInfo<Ad> adList = apiAdService.queryAdList(page, pageSize, type);
        List<Object> list = new ArrayList<>();
        for (Ad o : adList.getRecords()) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("origianl",o.getUrl());
            list.add(map);
        }
        return WebResult.ok(list);
    }
}
