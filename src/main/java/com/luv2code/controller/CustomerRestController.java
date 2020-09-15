/**
 * createdBY-Abhinav.
 *Using Database
 */

package com.luv2code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.RequestVO.CustomerVO;
import com.luv2code.entity.Customer;

import com.luv2code.exception.StudentNotFoundException;
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

		Customer customer = customerService.getCustomer(customerId);
		if (customer == null)
			throw new StudentNotFoundException("Customer Not Found " + customerId);
		return customer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody CustomerVO customerVo) {

		if(customerVo.getId()>0)
			throw new StudentNotFoundException("id is not required for adding an customer " + customerVo.getId());
		return customerService.saveCustomer(customerVo);

	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody CustomerVO customerVo) {

		Customer customer = customerService.getCustomer(customerVo.getId());
		if (customer == null)
			throw new StudentNotFoundException("Customer Not Found " + customerVo.getId());
		return customerService.saveCustomer(customerVo);

	}
	
	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomers(@PathVariable int customerId) {

		Customer customer = customerService.getCustomer(customerId);
		if (customer == null)
			throw new StudentNotFoundException("Customer Not Found " + customerId);
		 customerService.deleteCustomer(customerId);
		 return customer;
	}
	
	

}
