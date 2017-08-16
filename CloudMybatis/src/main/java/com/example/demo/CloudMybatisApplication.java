package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.example.demo")
@MapperScan(basePackages = "com.example.demo.dao")
public class CloudMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudMybatisApplication.class, args);
	}
}
