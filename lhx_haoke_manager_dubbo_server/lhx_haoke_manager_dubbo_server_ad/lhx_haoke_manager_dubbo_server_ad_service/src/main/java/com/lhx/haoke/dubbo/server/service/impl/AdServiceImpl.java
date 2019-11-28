package com.lhx.haoke.dubbo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lhx.haoke.dubbo.server.pojo.Ad;
import com.lhx.haoke.dubbo.server.service.AdService;
import com.lhx.haoke.dubbo.server.service.BaseServiceImpl;
import com.lhx.haoke.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl extends BaseServiceImpl<Ad>implements AdService {

    @Override
    public PageInfo<Ad> queryAdList(int page, int pageSize, int type) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("updated");
        queryWrapper.eq("type",type);
        IPage iPage = super.queryPageList(queryWrapper, page, pageSize);
        return new PageInfo<Ad>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
    }
}
