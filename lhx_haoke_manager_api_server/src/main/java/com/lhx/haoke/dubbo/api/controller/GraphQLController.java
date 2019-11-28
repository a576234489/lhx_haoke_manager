package com.lhx.haoke.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("graphql")
@CrossOrigin
public class GraphQLController {

    public static final ObjectMapper MAPPER  = new ObjectMapper();

    @Autowired
    private GraphQL graphQL;

    @GetMapping
    @ResponseBody
    public Map<String,Object> graphql(@RequestParam("query") String query,
                                      @RequestParam(value = "variables",required = false)String variables,
                                      @RequestParam(value = "operationName",required = false)String operationName){
        try {
            Map<String,Object> map = MAPPER.readValue(variables,MAPPER.getTypeFactory().constructMapType(HashMap.class,String.class,Object.class));
            return this.executeQuery(query,operationName,map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> err = new HashMap<>();
        err.put("status",500);
        err.put("msg","错误");
        return err;
    }

    @PostMapping
    @ResponseBody
    public Map<String,Object> psotGraphql(@RequestBody Map<String,Object> map){

        try {
            String query = (String) map.get("query");
            Map variables = (Map) map.get("variables");
            String operationName = (String) map.get("operationName");
            return this.executeQuery(query,operationName,variables);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, Object> err = new HashMap<>();
        err.put("status",500);
        err.put("msg","错误");
        return err;
    }
    private Map<String, Object> executeQuery(String query, String operationName, Map<String, Object> variables){
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .operationName(operationName)
                .variables(variables)
                .build();
        return this.graphQL.execute(executionInput).toSpecification();
    }

}
