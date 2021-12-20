package com.karam.gyw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.karam.gyw.model.CartModel;
import com.karam.gyw.model.GywModel;
import com.karam.gyw.service.CartService;

@Controller
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/saveCart/{product_name}")
	public String saveCustomer(@ModelAttribute("product_name") CartModel cartModel) {
		cartService.saveCart(cartModel);
		return "redirect:/showCartPage";
	}

	@GetMapping("/showCartItems")
	public String showCartItems(Model model) {

		// create model attribute to bind form data
		List<CartModel> cartModel1 = cartService.getAllCart();
		System.out.println("getall cart items " + cartModel1);
		model.addAttribute("cartAttr", cartModel1);

		return "cart";
	}

	@GetMapping("/showAddCartItemPage")
	public String showAddCartItemPage(Model model) {
		
		GywModel cartModel1 = new GywModel();
		System.out.println("getall cart items " + cartModel1);
		model.addAttribute("cartAttr", cartModel1);
		
		return "cartItem";
	}

	@PostMapping("/addCartItem")
	public String addCartItem(CartModel cartModel) {

		String product_name = "Facit Dashboard";
		String price = "19.99";
		CartModel cartModel1 = cartService.saveCartItems(product_name, price);

		System.out.println("addCartItem cartModel ::  " + cartModel1);

		// cartService.saveCart(cartModel);

		return "redirect:/showCartItems";
	}
	
	
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
