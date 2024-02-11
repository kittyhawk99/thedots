package com.co.thedots.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.thedots.entity.Class_date_info;
import com.co.thedots.entity.Store_info;

@Repository
public interface ClassDateRepository extends JpaRepository<Class_date_info, String>{

	Class_date_info findByClassDate(String class_date);
	
	//Long exists(Class_date_info cd);
	
}
