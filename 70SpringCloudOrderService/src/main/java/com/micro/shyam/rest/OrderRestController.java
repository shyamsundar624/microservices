package com.micro.shyam.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.consumer.CartConsumerFeign;
import com.micro.shyam.entity.Cart;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	@Autowired
	private CartConsumerFeign consumer;

	@GetMapping("/place")
	public ResponseEntity<String> placeOrder() {
		String cartRes = consumer.showMsg().getBody();
		return ResponseEntity.ok("ORDER PLACE WITH => " + cartRes);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<String> fetchOrderWithCart(@PathVariable("id") Integer id) {
		Cart cObj = consumer.getCartById(id).getBody();
		return ResponseEntity.ok("ORDER WITH CART DATA => " + cObj);

	}
	@PostMapping("/addToCart ")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart){
		String cartRes = consumer.addToCart(cart).getBody();
		return ResponseEntity.ok("ORDER WITH => "+cartRes);
	}
}
