package com.karam.gyw.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "customer_t")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerModel {

		
		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		private long id;
		
		@Column(name = "user_name")
		private String user_name;
		
//		@Column(name = "first_name")
//		private String first_name;
//		
//		@Column(name = "last_name")
//		private String last_name;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "confirm_password")
		private String confirm_password;
		
		@Column(name = "phone")
		private String phone;
		
//		@Column(name = "created_time", updatable=false)
//		private Date created_time;
		
//		@Enumerated(EnumType.STRING)
//		@Column(name = "auth_provider")
//		public AuthenticationProvider auth_provider;
		
//		private boolean enabled;
		
		@Column(name = "otp")
		private String otp;

		
		
		
		
		
}
