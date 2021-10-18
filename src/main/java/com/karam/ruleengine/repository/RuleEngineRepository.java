package com.karam.ruleengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karam.ruleengine.model.RuleEngineModel;

@Repository
public interface RuleEngineRepository extends JpaRepository<RuleEngineModel, Long>{

}
