package com.pratiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratiti.entity.Customer;
import com.pratiti.exception.CustomerServiceException;
import com.pratiti.model.LoginStatus;
import com.pratiti.model.RegistrationStatus;
import com.pratiti.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/register")
	public RegistrationStatus register(@RequestBody Customer customer) {
		RegistrationStatus status=new RegistrationStatus();
		try {
			int id=customerService.register(customer);
			status.setRegisterCustomerId(id);
			status.setStatus(true);
			status.setMesssageIfAny("Registration successfull , admin will verify soon");
			return status;
			
		}
		catch(CustomerServiceException e) {
			status.setMesssageIfAny(e.getMessage());
			status.setStatus(false);
			
			return status;
			
		}		
	}
	
	@PostMapping("/login")
	public LoginStatus login(@RequestBody CustomerLoginData customerData) {
		
	}
	
	@PostMapping("/register-internet-banking")
	//for register internet banking we get the account number verify it by sending opt to mail
	//then we ask for user to enter username and password as he wish then we store 
	//the data inside the account table and from there we can get the customer id
	public RegistrationStatus registerEbanking() {
	}
	
	@PostMapping("/forgot-user-id")
	@PostMapping("/forgot-password")
	@PostMapping("/set-new-password")
	
	

}
