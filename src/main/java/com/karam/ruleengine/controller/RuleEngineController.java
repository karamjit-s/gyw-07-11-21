package com.karam.ruleengine.controller;

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

import com.karam.ruleengine.model.RuleEngineModel;
import com.karam.ruleengine.service.RuleEngineService;

@Controller
public class RuleEngineController {

	@Autowired
	private RuleEngineService ruleEngineService;
	
	// display list of rules
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "action", "asc", model);		
	}
	
	@GetMapping("/showRuleForm")
	public String showNewRuleForm(Model model) {
		// create model attribute to bind form data
		RuleEngineModel rules = new RuleEngineModel();
		model.addAttribute("rules", rules);
		return "new_rule";
	}
	
	@PostMapping("/saveRule")
	public String saveRule(@ModelAttribute("rules") RuleEngineModel ruleEngineModel) {
		// save rule to database
		ruleEngineService.saveRule(ruleEngineModel);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get rule from the service
		RuleEngineModel ruleEngineModel = ruleEngineService.getRuleById(id);
		
		// set rule as a model attribute to pre-populate the form
		model.addAttribute("rules", ruleEngineModel);
		return "update_rule";
	}
	
	@GetMapping("/deleteRule/{id}")
	public String deleteRule(@PathVariable (value = "id") long id) {
		
		// call delete rule method 
		this.ruleEngineService.deleteRuleById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<RuleEngineModel> page = ruleEngineService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<RuleEngineModel> listRules = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listRules", listRules);
		return "index";
	}
}
