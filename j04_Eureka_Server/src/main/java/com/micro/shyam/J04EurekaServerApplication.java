package com.micro.shyam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class J04EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(J04EurekaServerApplication.class, args);
	}

}
