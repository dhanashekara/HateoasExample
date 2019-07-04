package com.hateoas.model;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Data
public class Orders extends ResourceSupport{
	
	String orderId;
	double price;
	int quantiy;
	String customerId;
	

}
