package com.karam.gyw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karam.gyw.model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{
	
	CustomerModel findByEmail(String email);
	
	
}
