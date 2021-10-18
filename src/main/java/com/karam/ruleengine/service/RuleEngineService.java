package com.karam.ruleengine.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.karam.ruleengine.model.RuleEngineModel;

public interface RuleEngineService {
	
	List<RuleEngineModel> getAllRules();
	
	void saveRule(RuleEngineModel ruleEngineModel);

	RuleEngineModel getRuleById(long id);
	
	void deleteRuleById(long id);
	
	Page<RuleEngineModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
