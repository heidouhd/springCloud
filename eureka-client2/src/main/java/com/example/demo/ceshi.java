package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/7/27.
 */
@RestController
public class ceshi {

    @Autowired
//    public SayHelloClient sayHelloClient;
    @RequestMapping(value = "info",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public String info(){
//        String s = sayHelloClient.sayHello();
        return "info";
    }
}
