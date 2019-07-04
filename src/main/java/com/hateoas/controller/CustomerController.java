package com.hateoas.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hateoas.model.Customer;
import com.hateoas.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers/{id}")
	public Resource<Customer> getCustomer(@PathVariable("id") int customerId) {
		
		Customer customer = customerService.getCustomer(customerId);
		Resource<Customer> resource = new Resource<Customer>(customer);

		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllCustomers());
		resource.add(linkTo.withRel("all-Customers"));

		return resource;

	}

	@GetMapping("/customers")
	protected Resources<Customer> getAllCustomers() {

		List<Customer> allCustomers = customerService.getAllCustomer();

		for (Customer customer : allCustomers) {

			int customerId = customer.getCustomerId();
			Link selfLink = linkTo(CustomerController.class).slash(customerId).withSelfRel();
			customer.add(selfLink);
		}

		Link link = linkTo(CustomerController.class).withSelfRel();
		Resources<Customer> result = new Resources<Customer>(allCustomers, link);
		return result;

	}

}
