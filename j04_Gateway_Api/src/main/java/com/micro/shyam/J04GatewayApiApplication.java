package com.micro.shyam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class J04GatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(J04GatewayApiApplication.class, args);
	}

}
