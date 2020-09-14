/**
 * createdBY-Abhinav.
 *Using Database
 */

package com.luv2code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.entity.Customer;
import com.luv2code.service.CustomerService;

@RestController
@RequestMapping("/api/v2")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {

		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId) {

		return customerService.getCustomer(customerId);
	}

}
