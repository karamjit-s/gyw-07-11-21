package com.karam.gyw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karam.gyw.model.CustomerModel;
import com.karam.gyw.repository.CustomerRepository;
import com.karam.gyw.service.CustomerService;
import com.karam.gyw.service.PhoneverificationService;

@Controller

public class CustomerController {


	@Autowired
	private CustomerService customerService ;
	
	@Autowired
	private CustomerRepository customerRepository ;
	
	@Autowired
	PhoneverificationService phonesmsservice;
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer_attribute") CustomerModel customerModel) {
		customerService.saveCustomer(customerModel);
		return "redirect:/showCustomerList";
	}
	
	@GetMapping("/showCustomerList")
	public String showCustomerList(Model model) {
		// create model attribute to bind form data
		List<CustomerModel> customerModel = customerService.getAllCustomers();		
		System.out.println("getall customer "+customerModel);
		model.addAttribute("customerAttr", customerModel);
		return "customerList";
	}
	
	

	@GetMapping("/showCustomerUpdateForm/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		CustomerModel customerModel = customerService.getCustomerById(id);		
		model.addAttribute("customerAttr", customerModel);
		
		return "customerUpdateForm";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable (value = "id") long id) {
		
		this.customerService.deleteCustomerById(id);

		return "redirect:/showCustomerList";
	}
	

	@GetMapping("/signup")
	public String showSignUpForm(Model model) {
		// create model attribute to bind form data
		CustomerModel customerModel = new CustomerModel();
		model.addAttribute("customer_attribute", customerModel);
		return "signup";
	}
	
	@GetMapping("/login")
	public String showLogInForm(Model model) {
		CustomerModel customerModel = new CustomerModel();
		model.addAttribute("customer_attribute", customerModel);
		
		List<CustomerModel> getall = customerService.getAllCustomers();
		System.out.println(getall);
		
		return "login";
	}
	
	@PostMapping("/verifyCustomer")
	public String verifyLogIn(@ModelAttribute("customer_attribute") CustomerModel customerModel,
			 @RequestParam("email") String email) {
		
		String email1 = email;
		System.out.println("email1 == "+email1);

		CustomerModel temp=	customerRepository.findByEmail(email1);
		System.out.println("temp == "+temp);
		
		if(temp!=null) {
			System.out.println("Login Successfull, Welcome To GYW Platform");
			return "redirect:/";
		}
		else {
			System.out.println("Login failed");
			return "redirect:/login";
		}
		
	}

	

	
}