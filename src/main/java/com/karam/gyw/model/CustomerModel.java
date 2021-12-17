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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm_password() {
			return confirm_password;
		}

		public void setConfirm_password(String confirm_password) {
			this.confirm_password = confirm_password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getOtp() {
			return otp;
		}

		public void setOtp(String otp) {
			this.otp = otp;
		}

		
		
		
		
		
}
