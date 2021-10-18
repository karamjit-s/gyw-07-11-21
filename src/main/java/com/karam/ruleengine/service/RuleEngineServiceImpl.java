package com.karam.ruleengine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.karam.ruleengine.model.RuleEngineModel;
import com.karam.ruleengine.repository.RuleEngineRepository;

@Service
public class RuleEngineServiceImpl implements RuleEngineService {

	@Autowired
	private RuleEngineRepository ruleEngineRepository;

	@Override
	public List<RuleEngineModel> getAllRules() {
		return ruleEngineRepository.findAll();
	}

	@Override
	public void saveRule(RuleEngineModel ruleEngineModel) {
		this.ruleEngineRepository.save(ruleEngineModel);
	}

	@Override
	public RuleEngineModel getRuleById(long id) {
		Optional<RuleEngineModel> optional = ruleEngineRepository.findById(id);
		RuleEngineModel ruleEngineModel = null;
		if (optional.isPresent()) {
			ruleEngineModel = optional.get();
		} else {
			throw new RuntimeException(" Rule not found for id :: " + id);
		}
		return ruleEngineModel;
	}

	@Override
	public void deleteRuleById(long id) {
		this.ruleEngineRepository.deleteById(id);
	}

	@Override
	public Page<RuleEngineModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.ruleEngineRepository.findAll(pageable);
	}
}
