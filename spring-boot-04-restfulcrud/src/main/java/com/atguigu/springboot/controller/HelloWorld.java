package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @auther gxf
 * @date2020/6/28-17:46
 */
@Controller
public class HelloWorld {
//@RequestMapping({"/","index.html"})
//    public  String index(){
//        return  "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {

          return    "HelloWorldMMMMMMMDDD";

    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h2>您好</h2>");
        map.put("users", Arrays.asList("张无忌","赵敏","周芷若"));
        return "success";
    }


}