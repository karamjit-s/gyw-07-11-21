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
		private int id;
		
		@Column(name = "user_name")
		private String user_name;
		
		@Column(name = "full_name")
		private String full_name;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "gender")
		private String gender;
	
		@Column(name = "password")
		private String password;
		
		@Column(name = "confirm_password")
		private String confirm_password;
		
		@Column(name = "contact")
		private String contact;
	
		@Column(name = "address")
		private String address;
		
		@Column(name = "company_name")
		private String company_name;

		@Column(name = "agree")
		private boolean agree;

		public long getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getFull_name() {
			return full_name;
		}

		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
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

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCompany_name() {
			return company_name;
		}

		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}

		public boolean isAgree() {
			return agree;
		}

		public void setAgree(boolean agree) {
			this.agree = agree;
		}

		
		
		
		
		
		
		
}
