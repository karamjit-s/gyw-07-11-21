package com.karam.gyw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karam.gyw.model.CustomerModel;
import com.karam.gyw.repository.CustomerRepository;
import com.karam.gyw.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	/* GetALL */
	@Override
	public List<CustomerModel> getAllCustomers() {
		return customerRepository.findAll();
	}

	/* CREATE by ID */
	@Override
	public void saveCustomer(CustomerModel customerModel) {
		this.customerRepository.save(customerModel);
	}


	
	/* GET by ID */
	@SuppressWarnings("unchecked")
	public CustomerModel getCustomerById(long id) throws ResourceNotFoundException {
		CustomerModel customerModel = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: " + id));
		
		return customerModel;
	}
	
	/* DELETE by ID */
	public Map<String, Boolean> deleteCustomerById(long id) throws ResourceNotFoundException {
		CustomerModel customerModel = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

		customerRepository.delete(customerModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}

