package com.lhx.haoke.dubbo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lhx.haoke.dubbo.server.pojo.HouseResources;
import com.lhx.haoke.dubbo.server.service.BaseServiceImpl;
import com.lhx.haoke.dubbo.server.service.HouseResoucesService;
import com.lhx.haoke.dubbo.server.vo.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HouseResoucesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResoucesService {


    @Override
    public int saveHouseResources(HouseResources houseResources) {
        if(StringUtils.isBlank(houseResources.getTitle())){
            return -1;
        }
        return super.save(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        QueryWrapper<HouseResources> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("created");
        IPage<HouseResources> iPage = super.queryPageList(wrapper, page, pageSize);
        return new PageInfo<HouseResources>(Long.valueOf(iPage.getTotal()).intValue(),page,pageSize,iPage.getRecords());
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return super.queryById(id);
    }
}
