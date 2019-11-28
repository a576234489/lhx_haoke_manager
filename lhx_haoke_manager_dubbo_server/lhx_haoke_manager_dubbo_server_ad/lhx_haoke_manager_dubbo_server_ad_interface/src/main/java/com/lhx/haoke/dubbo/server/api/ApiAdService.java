package com.lhx.haoke.dubbo.server.api;

import com.lhx.haoke.dubbo.server.pojo.Ad;
import com.lhx.haoke.dubbo.server.vo.PageInfo;

public interface ApiAdService {
    PageInfo<Ad> queryAdList(int page,int pageSize,int type);
}
