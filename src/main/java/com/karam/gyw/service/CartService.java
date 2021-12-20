package com.karam.gyw.service;

import java.util.List;

import com.karam.gyw.model.CartModel;

public interface CartService {

	public void saveCart(CartModel cartModel);
	
	public List<CartModel> getAllCart();
	
	public CartModel saveCartItems(String product_name, String price);		
}
