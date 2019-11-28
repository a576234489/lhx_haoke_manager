package com.lhx.haoke.dubbo.api.controller;

import com.lhx.haoke.dubbo.api.service.HouseResourcesService;
import com.lhx.haoke.dubbo.api.vo.TableResult;
import com.lhx.haoke.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("house/resources")
public class HouseResourcesController {
    @Autowired
    private HouseResourcesService houseResourcesService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources){
        try {
            if(houseResourcesService.save(houseResources)){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<TableResult> list(HouseResources houseResources,@RequestParam(name = "currentPage",defaultValue = "1")Integer currentPage,
                                            @RequestParam(name = "pageSize",defaultValue = "10")Integer pageSize){
        return ResponseEntity.ok(this.houseResourcesService.queryList(houseResources,currentPage,pageSize));
    }
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HouseResources> list(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.houseResourcesService.queryHouseResourcesById(id));
    }

//    @GetMapping
//    @ResponseBody
//    public ResponseEntity<String> get(){
//        return ResponseEntity.ok("ok");
//    }
}
