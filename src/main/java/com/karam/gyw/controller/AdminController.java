package com.karam.gyw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.karam.gyw.model.GywModel;
import com.karam.gyw.service.GywService;

@Controller

public class AdminController {

	@Autowired
	private GywService ruleEngineService;
	
	// display admin page
	@GetMapping("/admin")
	public String viewHomePage(Model model) {
		return "admin";		
	}
	
//	@GetMapping("/showRuleForm")
//	public String showNewRuleForm(Model model) {
//		// create model attribute to bind form data
//		GywModel rules = new GywModel();
//		model.addAttribute("rules", rules);
//		return "new_rule";
//	}
//	
//	@PostMapping("/saveRule")
//	public String saveRule(@ModelAttribute("rules") GywModel ruleEngineModel) {
//		// save rule to database
//		ruleEngineService.saveRule(ruleEngineModel);
//		return "redirect:/";
//	}
//	
//	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
//		
//		// get rule from the service
//		GywModel ruleEngineModel = ruleEngineService.getRuleById(id);
//		
//		// set rule as a model attribute to pre-populate the form
//		model.addAttribute("rules", ruleEngineModel);
//		return "update_rule";
//	}
//	
//	@GetMapping("/deleteRule/{id}")
//	public String deleteRule(@PathVariable (value = "id") long id) {
//		
//		// call delete rule method 
//		this.ruleEngineService.deleteRuleById(id);
//		return "redirect:/";
//	}
	
}