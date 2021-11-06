package com.karam.gyw.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.karam.gyw.model.GywModel;

public interface GywService {
	
	List<GywModel> getAllRules();
	
	void saveRule(GywModel ruleEngineModel);

	GywModel getRuleById(long id);
	
	void deleteRuleById(long id);
	
	Page<GywModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
