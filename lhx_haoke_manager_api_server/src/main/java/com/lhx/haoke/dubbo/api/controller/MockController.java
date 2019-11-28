package com.lhx.haoke.dubbo.api.controller;

import com.lhx.haoke.dubbo.api.config.MockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mock")
@CrossOrigin
public class MockController {
    @Autowired
    private MockConfig mockConfig;

    @GetMapping("index/menu")
    private String indexMenu(){
        return mockConfig.getIndexMenu();
    }
    @GetMapping("index/info")
    private String indexInfo(){
        return mockConfig.getIndexInfo();
    }
    @GetMapping("index/faq")
    private String indexFaq(){
        return mockConfig.getIndexFaq();
    }
    @GetMapping("index/house")
    private String indexHose(){
        return mockConfig.getIndexHouse();
    }
    @GetMapping("infos/list")
    private String infosList(@RequestParam("type")Integer type){
        switch (type){
            case 1:
                return mockConfig.getInfosList1();
            case 2:
                return mockConfig.getInfosList2();
            case 3:
                return mockConfig.getInfosList3();
        }
        return mockConfig.getInfosList1();
    }
    @GetMapping("my/info")
    private String myInfo(){
        return mockConfig.getMy();
    }
}
