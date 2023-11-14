package com.micro.shyam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/info")
	public ResponseEntity<String> showOrderInfo(){
		return ResponseEntity.ok("From Order Service, Port# is: "+port);
	}
}
