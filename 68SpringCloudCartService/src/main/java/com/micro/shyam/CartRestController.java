package com.micro.shyam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartRestController {
@GetMapping("/info")
	public ResponseEntity<String> showMsg(){
		return ResponseEntity.ok("WELCOME TO CART SERVICE");
	}
}
