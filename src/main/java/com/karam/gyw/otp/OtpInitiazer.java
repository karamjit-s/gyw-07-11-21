package com.karam.gyw.otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class OtpInitiazer {

	
	private final OtpProperties twilioproperties;
	
	@Autowired
	public OtpInitiazer(OtpProperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
		Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
		System.out.println("Twilio initialized with account-"+twilioproperties.getAccountSid());
	}
}
