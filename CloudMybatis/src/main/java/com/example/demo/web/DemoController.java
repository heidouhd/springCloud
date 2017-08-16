package com.example.demo.web;

import com.example.demo.domain.Demo;
import com.example.demo.service.DemoService;
import com.example.demo.util.HttpUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/8/8.
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/getDemoById",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=UTF-8")
    public Demo Demo(
            @RequestParam(value = "id" , required = true) Long id,
            HttpServletRequest request
    ){
        HttpUtil.getParamMap(request);
        System.out.print(request.getParameter("fuck"));
        Demo demo = demoService.selectByPrimaryKey(id);
        return demo;
    }

}
