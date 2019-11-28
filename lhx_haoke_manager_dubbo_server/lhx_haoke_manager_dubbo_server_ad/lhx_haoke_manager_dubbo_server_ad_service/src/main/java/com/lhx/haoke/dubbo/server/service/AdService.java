package com.lhx.haoke.dubbo.server.service;

import com.lhx.haoke.dubbo.server.pojo.Ad;
import com.lhx.haoke.dubbo.server.vo.PageInfo;

public interface AdService{
    PageInfo<Ad> queryAdList(int page, int pageSize, int type);
}
