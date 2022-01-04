package com.karam.gyw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karam.gyw.exception.ResourceNotFoundException;
import com.karam.gyw.model.CartModel;
import com.karam.gyw.model.CustomerModel;
import com.karam.gyw.model.GywModel;
import com.karam.gyw.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;
	
	
	
	@GetMapping("/addCartItem/{product_name}/{price}")
	public String addCartItem(@PathVariable String product_name,
			@PathVariable String price,
		@Valid CartModel cartModel, BindingResult result) throws ResourceNotFoundException{
		System.out.println("addCartItem controller called");
		
		String product_name1 = product_name; 
		System.out.println("product_name :: "+product_name1);
		
		String price1 = price; 
		System.out.println("price1 :: "+price1);
		
		
		 cartService.saveCartItems(product_name1,price);	
		
//		model.addAttribute("cartAttr", cartModel);
		
//		cartService.saveCart(cartModel);
		return "redirect:/showDesignsPage";
	}

	@GetMapping("/showCartItems")
	public String showCartItems(Model model) {

		List<CartModel> cartModel = cartService.getAllCartItems();		
		System.out.println("getall customer "+cartModel);
		model.addAttribute("cartAttr", cartModel);

		return "cart";
	}

	@GetMapping("/deleteCartItem/{product_id}")
	public String deleteCartItem(@PathVariable (value = "product_id") int product_id) {
		
		this.cartService.deleteCartItemById(product_id);

		return "redirect:/showCartItems";
	}
	
	
	
	
//	@GetMapping("/showAddCartItemPage")
//	public String showAddCartItemPage(Model model) {
//		
//		GywModel cartModel1 = new GywModel();
//		System.out.println("getall cart items " + cartModel1);
//		model.addAttribute("cartAttr", cartModel1);
//		
//		return "cartItem";
//	}

	
	
	@GetMapping("/checkoutPageShow")
	public String checkoutPageShow(Model model) {
		
		GywModel cartModel1 = new GywModel();
		System.out.println("getall cart items " + cartModel1);
		model.addAttribute("cartAttr", cartModel1);
		
		return "checkout";
	}
	
	@GetMapping("/buyItems")
	public String buyItems(Model model) {
		
		GywModel cartModel1 = new GywModel();
		System.out.println("getall cart items " + cartModel1);
		model.addAttribute("cartAttr", cartModel1);
		
		return "checkout";
	}
	
	
	
	
}
