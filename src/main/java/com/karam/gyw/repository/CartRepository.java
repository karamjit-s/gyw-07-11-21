package com.karam.gyw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karam.gyw.model.CartModel;

@Repository
public interface CartRepository extends JpaRepository<CartModel, Long>{

}
