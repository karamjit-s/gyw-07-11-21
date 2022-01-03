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

	@Override
	public ResponseEntity<CustomerModel> update(int id, CustomerModel customerModel) throws ResourceNotFoundException {

		CustomerModel customerModel1 = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CustomerModel not found for this id :: " + id));

		customerModel1.setUser_name(customerModel.getUser_name());
		customerModel1.setFull_name(customerModel.getFull_name());
		customerModel1.setEmail(customerModel.getEmail());
		customerModel1.setCompany_name(customerModel.getCompany_name());
		customerModel1.setContact(customerModel.getContact());
		customerModel1.setAddress(customerModel.getAddress());

		/*
		 * customerModel1.setGender(customerModel.getGender());
		 * customerModel1.setPassword(customerModel.getPassword());
		 * customerModel1.setConfirm_password(customerModel.getConfirm_password());
		 * customerModel1.setAgree(customerModel.isAgree());
		 */
		

		final CustomerModel updatedUser = customerRepository.save(customerModel1);
		return ResponseEntity.ok(updatedUser);
	}
	
	/* GET by ID */
	@SuppressWarnings("unchecked")
	public CustomerModel getCustomerById(int id) throws ResourceNotFoundException {
		CustomerModel customerModel = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: " + id));
		
		return customerModel;
	}
	
	/* DELETE by ID */
	public Map<String, Boolean> deleteCustomerById(int id) throws ResourceNotFoundException {
		CustomerModel customerModel = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));

		customerRepository.delete(customerModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}

