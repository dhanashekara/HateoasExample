package com.hateoas.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hateoas.model.Customer;

@Repository
public class CustomerRepo {

	public static Map<Integer, Customer> customerMap;
	static {

		Customer customer1 = new Customer(10, "Amith", "HCL");
		Customer customer2 = new Customer(20, "Arti", "TCS");
		Customer customer3 = new Customer(30, "Arun", "Infosis");

		customerMap = new HashMap<>();
		customerMap.put(10, customer1);
		customerMap.put(20, customer2);
		customerMap.put(30, customer3);
	}

}
