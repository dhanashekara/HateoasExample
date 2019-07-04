package com.hateoas.model;

import org.springframework.hateoas.ResourceSupport;

import lombok.Data;

@Data
public class Customer extends ResourceSupport{
	
	private int customerId;
	private String customerName;
	private String companyName;
	
	public Customer(int customerId, String customerName, String companyName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.companyName = companyName;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
