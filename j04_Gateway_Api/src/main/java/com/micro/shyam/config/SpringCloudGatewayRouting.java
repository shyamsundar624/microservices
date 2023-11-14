package com.micro.shyam.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
	 @Bean
	    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
	       return builder.routes()
	      .route("bookId", r->r.path("/book/**").uri("http://BOOK-SERVICE:9009")) //static routing
	      .route("studentId", r->r.path("/student/**").uri("lb://STUDENT-SERVICE")) //dynamic routing
	      .build();
	    }
}
