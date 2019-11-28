package com.lhx.haoke.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.lhx.haoke.dubbo.server.pojo.Ad;
import com.lhx.haoke.dubbo.server.service.AdService;
import com.lhx.haoke.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiAdServiceImpl implements ApiAdService{
    @Autowired
    private AdService adService;

    @Override
    public PageInfo<Ad> queryAdList(int page, int pageSize, int type) {
        return adService.queryAdList(page,pageSize,type);
    }
}
