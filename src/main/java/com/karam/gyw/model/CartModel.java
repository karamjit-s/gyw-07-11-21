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

		public long getProduct_id() {
			return product_id;
		}

		public void setProduct_id(long product_id) {
			this.product_id = product_id;
		}

		public String getProduct_name() {
			return product_name;
		}

		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}
		
		
		
}
