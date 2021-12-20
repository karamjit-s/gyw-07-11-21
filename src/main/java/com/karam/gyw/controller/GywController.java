package com.karam.gyw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karam.gyw.model.CartModel;
import com.karam.gyw.model.GywModel;
import com.karam.gyw.service.CartService;
import com.karam.gyw.service.GywService;

@Controller
public class GywController {

	@Autowired
	private GywService gywService;
	
	@Autowired
	private CartService cartService;
	
	// display list of gywModel
//	@GetMapping("/")
//	public String viewHomePage(Model model) {
//		return findPaginated(1, "action", "asc", model);		
//	}
	
//	@GetMapping("/showRuleForm")
//	public String showNewRuleForm(){
//		return "new_rule";
//	}
	
	@PostMapping("/saveRule")
	public String saveRule(@ModelAttribute("gywAttr") GywModel gywModel) {
		// save rule to database
		gywService.saveRule(gywModel);
		return "redirect:/";
	}
	
//	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
//		
//		// get rule from the service
//		GywModel gywModel = gywService.getRuleById(id);
//		
//		// set rule as a model attribute to pre-populate the form
//		model.addAttribute("gywModel", gywModel);
//		return "update_rule";
//	}
	
	@GetMapping("/deleteRule/{id}")
	public String deleteRule(@PathVariable (value = "id") long id) {
		
		// call delete rule method 
		this.gywService.deleteRuleById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<GywModel> page = gywService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<GywModel> listgywModel = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listgywModel", listgywModel);
		return "index";
	}
	
	
	@GetMapping("/showServicesPage")
	public String showServicesPage(Model model) {

		GywModel gywModel = new GywModel();
		model.addAttribute("gywModel", gywModel);
		return "services";
	}
	
	@GetMapping("/showDesignsPage")
	public String showDesignsPage(Model model) {

		GywModel gywModel = new GywModel();
		model.addAttribute("gywModel", gywModel);
		
		
		// create model attribute to bind form data
				List<CartModel> cartModel1= cartService.getAllCart();		
				System.out.println("getall cart items " + cartModel1);
				model.addAttribute("cartAttr", cartModel1);
				
				
		return "designs";
	}
	
	@GetMapping("/showOffersPage")
	public String showOffersPage(Model model) {

		GywModel gywModel = new GywModel();
		model.addAttribute("gywModel", gywModel);
		return "offers";
	}
	@GetMapping("/showSupportPage")
	public String showSupportPage(Model model) {

		GywModel gywModel = new GywModel();
		model.addAttribute("gywModel", gywModel);
		return "support";
	}
	
	@GetMapping("/showCartPage")
	public String showOrdersPage(Model model) {

		GywModel gywModel = new GywModel();
		model.addAttribute("gywModel", gywModel);
		return "cart";
	}
	
	@GetMapping("/showProfilePage")
	public String showProfilePage(Model model) {

		GywModel gywModel = new GywModel();
		model.addAttribute("gywModel", gywModel);
		return "profile";
	}
	
	@GetMapping("/showAboutPage")
	public String showAboutPage(Model model) {

		GywModel gywModel = new GywModel();
		model.addAttribute("gywModel", gywModel);
		return "about";
	}
}
