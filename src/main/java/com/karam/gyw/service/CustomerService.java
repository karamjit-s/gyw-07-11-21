package com.karam.gyw.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.karam.gyw.exception.ResourceNotFoundException;
import com.karam.gyw.model.CustomerModel;

public interface CustomerService {

	
	public List<CustomerModel> getAllCustomers();
	
	public void saveCustomer(CustomerModel customerModel);
	
	public CustomerModel getCustomerById(int id) throws ResourceNotFoundException;
		
	public Map<String, Boolean> deleteCustomerById(int id) throws ResourceNotFoundException;

	public ResponseEntity<CustomerModel> update(int id, CustomerModel customerModel) throws ResourceNotFoundException ;
	
}
