package com.karam.gyw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karam.gyw.model.CartModel;
import com.karam.gyw.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartRepository cartRepository;
	
	
	/* GetALL */
	@Override
	public List<CartModel> getAllCart() {
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
		
		String product_name_value ="Facit Dark Theme";
		String price_value = "19.99";
		
		CartModel cartModel = new CartModel();
		cartModel.setProduct_name(product_name_value);
		cartModel.setPrice(price_value);

		return this.cartRepository.save(cartModel);
	}
	
}
