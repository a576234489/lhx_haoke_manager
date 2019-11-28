package com.lhx.haoke.dubbo.api.controller;

import com.lhx.haoke.dubbo.api.service.AdService;
import com.lhx.haoke.dubbo.api.vo.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ad")
@CrossOrigin
public class AdController {
    @Autowired
    private AdService adService;

    @GetMapping
    @ResponseBody
    public WebResult quertIndexAd(){
        return adService.queryAdList(1, 3, 1);
    }
}
