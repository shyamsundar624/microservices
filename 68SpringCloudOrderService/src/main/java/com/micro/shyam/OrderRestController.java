package com.micro.shyam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController {

	@Autowired
	private CartConsumer consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder(){
		String cartResponse = consumer.getCartResponse();
		return ResponseEntity.ok("Order Place With -> "+cartResponse);
	}
}
