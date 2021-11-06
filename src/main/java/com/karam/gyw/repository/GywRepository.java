package com.karam.gyw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karam.gyw.model.GywModel;

@Repository
public interface GywRepository extends JpaRepository<GywModel, Long>{

}
