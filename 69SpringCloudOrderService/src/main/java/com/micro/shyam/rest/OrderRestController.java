package com.micro.shyam.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.consumer.CartConsumer;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	@Autowired
	private CartConsumer consumer;
	
	public ResponseEntity<String> placeOrder(){
		String response = consumer.getResponse();
		return ResponseEntity.ok("Order placed With => "+response);
	}
	
	
}
