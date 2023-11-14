package com.micro.shyam.entity;

import lombok.Data;

@Data
public class Cart {
	private Integer cartId;
	private String cartCode;
	private Double cartCost;
}
