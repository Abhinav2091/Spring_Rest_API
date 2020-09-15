package com.luv2code.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.RequestVO.CustomerVO;
import com.luv2code.dao.CustomerDAO;
import com.luv2code.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer saveCustomer(CustomerVO theCustomer) {
		//id will be 0 by default mean add new entry
		Customer customer =new Customer();
		BeanUtils.copyProperties(theCustomer, customer);
		customerDAO.saveCustomer(customer);
		return customer;
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);
	}
}
