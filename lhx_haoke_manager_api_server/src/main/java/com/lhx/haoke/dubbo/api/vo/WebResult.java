package com.lhx.haoke.dubbo.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResult {
    @JsonIgnore
    private int status;
    @JsonIgnore
    private String msg;
    @JsonIgnore
    private List<?> list;
    @JsonIgnore
    public static WebResult ok(List<?> list){
        return  new WebResult(200,"成功",list);
    }
    @JsonIgnore
    public static WebResult ok(List<?> list,String msg){
        return new WebResult(200,msg,list);
    }

    public Map<String,Object> getData(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("list",this.list);
        return data;
    }
    public Map<String,Object> getMeta(){
        HashMap<String, Object> meta = new HashMap<>();
        meta.put("status",this.status);
        meta.put("msg",this.msg);
        return meta;
    }
}
