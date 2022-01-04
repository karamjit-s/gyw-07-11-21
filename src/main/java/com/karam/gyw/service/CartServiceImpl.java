package com.karam.gyw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karam.gyw.exception.ResourceNotFoundException;
import com.karam.gyw.model.CartModel;
import com.karam.gyw.model.CustomerModel;
import com.karam.gyw.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	
	/* GetALL */
	@Override
	public List<CartModel> getAllCartItems() {
		return cartRepository.findAll();
	}

	/* CREATE by ID */
	@Override
	public void saveCart(CartModel cartModel) {
		this.cartRepository.save(cartModel);
	}
	
	/* CREATE with param */
	@Override
	public CartModel saveCartItems(String product_name, String price) {
		
		String product_name_value =product_name;
		String price_value = price;
		
		CartModel cartModel = new CartModel();
		cartModel.setProduct_name(product_name_value);
		cartModel.setPrice(price_value);

		return this.cartRepository.save(cartModel);
	}
	
	/* DELETE by ID */
	public Map<String, Boolean> deleteCartItemById(int product_id) throws ResourceNotFoundException {
		CartModel cartModel = cartRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this product_id :: " + product_id));

		cartRepository.delete(cartModel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
