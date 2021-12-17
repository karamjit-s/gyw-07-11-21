package com.karam.gyw.otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karam.gyw.model.CustomerModel;
import com.karam.gyw.service.CustomerService;
import com.karam.gyw.service.PhoneverificationService;
import com.karam.gyw.service.VerificationResult;

@Controller
public class OtpController {
	
	@Autowired
	PhoneverificationService phonesmsservice;

	@Autowired
	CustomerService customerService;

	@RequestMapping("/")
	public String homepage(ModelAndView model) {
		return "index";
	}

	@PostMapping("/sendotp")
	public ResponseEntity<String> sendotp(@RequestParam("phone") String phone) {
		VerificationResult result = phonesmsservice.startVerification(phone);
		if (result.isValid()) {
			
			System.out.println("send otp sucess called");
			
			return new ResponseEntity<>("Otp Sent..", HttpStatus.OK);
		}
		
		System.out.println("send otp failed called");

		return new ResponseEntity<>("Otp failed to sent..", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/verifyotp")
	public String sendotp(@ModelAttribute("customer_attribute") CustomerModel customerModel,
			@RequestParam("phone") String phone, @RequestParam("otp") String otp) {
		VerificationResult result = phonesmsservice.checkverification(phone, otp);
		if (result.isValid()) {

			// save rule to database
			customerService.saveCustomer(customerModel);

			return "redirect:/";

		}
		return "Something wrong/ Otp incorrect";
	}

	
	@PostMapping("/signup")
	public String signup(@ModelAttribute("customer_attribute") CustomerModel customerModel) {
		
			customerService.saveCustomer(customerModel);
			
			System.out.println(customerModel);

			return "redirect:/";

	}

}
