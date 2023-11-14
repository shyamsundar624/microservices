package com.micro.shyam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	@Value("${server.port}")
	private String port;
	@GetMapping("/info")
	public ResponseEntity<String> showMsg(){
		return ResponseEntity.ok("Welcome TO Cart Service "+port);
	}
}
