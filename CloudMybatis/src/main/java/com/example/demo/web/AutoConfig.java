package com.example.demo.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lenovo on 2017/9/13.
 */
@ConfigurationProperties(prefix = "hello")
@Data
@Component
public class AutoConfig {
    private String name = "11";
    private Integer age = 22;
    private String address = "商店";

}
