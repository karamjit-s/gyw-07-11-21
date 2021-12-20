package com.karam.gyw.model;

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
@Table(name = "cart_items_t")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartModel {

		
		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		private long product_id;
		
		@Column(name = "product_name")
		private String product_name;
		
		@Column(name = "price")
		private String price;
		
		
		
}
