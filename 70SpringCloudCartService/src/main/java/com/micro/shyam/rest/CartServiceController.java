package com.micro.shyam.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.entity.Cart;

@RestController
@RequestMapping("/cart")
public class CartServiceController {
	@Value("${server.port}")
	private String port;

	@GetMapping("/info")
	public ResponseEntity<String> showMsg() {
		return ResponseEntity.ok("WELCOME TO CART SERVICE => " + port);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("id") Integer id) {
		Cart cart = new Cart();
		cart.setCartId(id);
		cart.setCartCost(2323.33);
		cart.setCartCode("Test");

		return ResponseEntity.ok(cart);
	}

	@PostMapping("/create")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart){
		return ResponseEntity.ok("Added To Cart => "+cart);
	}
}
