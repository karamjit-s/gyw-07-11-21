package com.karam.gyw.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.karam.gyw.model.GywModel;
import com.karam.gyw.repository.GywRepository;

@Service
public class GywServiceImpl implements GywService {

	@Autowired
	private GywRepository gywRepository;

	@Override
	public List<GywModel> getAllRules() {
		return gywRepository.findAll();
	}

	@Override
	public void saveRule(GywModel ruleEngineModel) {
		this.gywRepository.save(ruleEngineModel);
	}

	@Override
	public GywModel getRuleById(long id) {
		Optional<GywModel> optional = gywRepository.findById(id);
		GywModel ruleEngineModel = null;
		if (optional.isPresent()) {
			ruleEngineModel = optional.get();
		} else {
			throw new RuntimeException(" Rule not found for id :: " + id);
		}
		return ruleEngineModel;
	}

	@Override
	public void deleteRuleById(long id) {
		this.gywRepository.deleteById(id);
	}

	@Override
	public Page<GywModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.gywRepository.findAll(pageable);
	}
}
