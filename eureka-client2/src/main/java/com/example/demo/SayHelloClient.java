package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lenovo on 2017/7/26.
 */
@FeignClient("eureka-client")
public interface SayHelloClient {

    @RequestMapping(value = "/feign/sayHello", method = {RequestMethod.GET}, produces = "application/json;charset=UTF-8")
    public String sayHello();

}
