package com.karam.gyw.service;

import java.util.List;
import java.util.Map;

import com.karam.gyw.exception.ResourceNotFoundException;
import com.karam.gyw.model.CartModel;

public interface CartService {

	public void saveCart(CartModel cartModel);
	
	public List<CartModel> getAllCartItems();
	
	public CartModel saveCartItems(String product_name, String price);
	
	public Map<String, Boolean> deleteCartItemById(int product_id) throws ResourceNotFoundException ;
	
}
