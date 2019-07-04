package com.hateoas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hateoas.model.Customer;
import com.hateoas.repo.CustomerRepo;

@Service
public class CustomerService {

	public Customer getCustomer(int customerId) {
		return CustomerRepo.customerMap.get(customerId);
	}

	public List<Customer> getAllCustomer() {

		List<Customer> list = new ArrayList<>();
		for (Map.Entry<Integer, Customer> entry : CustomerRepo.customerMap.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
}
