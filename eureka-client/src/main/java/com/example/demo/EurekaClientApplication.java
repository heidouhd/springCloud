package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
@ComponentScan(basePackages = "com.example")
public class EurekaClientApplication {

	private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EurekaClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@RequestMapping(value = "/sayHi",produces = "application/json;charset=UTF-8")
	public String sayHi(){
		log.info("开始");
		return "hello";
	}

}
