package com.pratiti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratiti.entity.Customer;
import com.pratiti.entity.Customer.Status;
import com.pratiti.exception.CustomerServiceException;
import com.pratiti.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRespository;
	
	
	public int register(Customer customer) {
		if(!customerRespository.existsByAddharCardNumber(customer.getAddharCardNumber())) {
			customer.setStatus(Status.INACTIVE);
			customer.getAddress().setCustomer(customer);//here we are setting the customer column refernce in Address table
			customerRespository.save(customer);
			return customer.getCustomerId();
		}
		else {
			throw new CustomerServiceException("User already registered");
		}
		
	}

}
