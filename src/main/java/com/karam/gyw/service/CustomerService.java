package com.karam.gyw.service;

import java.util.List;
import java.util.Map;


import com.karam.gyw.exception.ResourceNotFoundException;
import com.karam.gyw.model.CustomerModel;

public interface CustomerService {

	
	public List<CustomerModel> getAllCustomers();
	
	public void saveCustomer(CustomerModel customerModel);
	
	public CustomerModel getCustomerById(long id) throws ResourceNotFoundException;
		
	public Map<String, Boolean> deleteCustomerById(long id) throws ResourceNotFoundException;

	
}
