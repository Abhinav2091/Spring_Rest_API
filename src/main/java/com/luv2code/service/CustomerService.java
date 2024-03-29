package com.luv2code.service;

import java.util.List;

import com.luv2code.RequestVO.CustomerVO;
import com.luv2code.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer saveCustomer(CustomerVO theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
