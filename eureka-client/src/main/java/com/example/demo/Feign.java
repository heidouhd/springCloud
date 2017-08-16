package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/7/26.
 */
@RestController
@RequestMapping(value = "/feign")
public class Feign {
    @RequestMapping(value = "/sayHello", method = {RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String sayHello(){
        return "hello";
    }
}
