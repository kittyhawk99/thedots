package com.co.thedots.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.thedots.entity.Store_info;

@Repository
public interface FamilyRepository extends JpaRepository<Store_info, String>{
	
}
