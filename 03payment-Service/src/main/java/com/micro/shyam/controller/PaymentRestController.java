package com.micro.shyam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.shyam.consumer.CartRestConsumer;

@RestController
@RequestMapping("/payment")
public class PaymentRestController {

	@Autowired
	private CartRestConsumer consumer;
	@GetMapping("/data")
	public String getPaymentData() {
		return "FROM PAYMENT-SERVICE : "+consumer.getCartInfo();
	}
}
