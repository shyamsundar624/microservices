package com.micro.shyam.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {

	public RouteLocator configureRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("paymentId",r->r.path("/paymnet/**").uri("http://localhost:9090"))//static Routing
				.route("orderId",r->r.path("/order/**").uri("lb://ORDER-SERVICE"))//dynamic routing
				.build();
	}
}
