package com.co.thedots.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.thedots.controller.model.SearchVo;
import com.co.thedots.entity.Class_date_info;
import com.co.thedots.entity.Class_date_reservation_info;
import com.co.thedots.entity.Store_info;
import com.co.thedots.service.repository.ChildRepository;
import com.co.thedots.service.repository.ClassDateRepository;
import com.co.thedots.service.repository.ClassRepository;
import com.co.thedots.service.repository.FamilyRepository;
import com.co.thedots.service.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassDateService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final ClassDateRepository classDateRepository;
    
    
	public ClassDateService(ClassDateRepository classDateRepository) {
		this.classDateRepository = classDateRepository;
	}
    
	public Class_date_info findOne(String date_uuid) {
		// TODO Auto-generated method stub
		return classDateRepository.getById(date_uuid);
	}

	public Optional<Class_date_info> findAllList(String date_uuid) {
		// TODO Auto-generated method stub
		return classDateRepository.findById(date_uuid);
	}
	
	public Class_date_info findClassOne(String class_date) {
		// TODO Auto-generated method stub
		return classDateRepository.findByClassDate(class_date);
	}	

	public Long exists(String date_uuid, String family_uuid, String child_uuid) {
		// TODO Auto-generated method stub
		
		Class_date_info cd = new Class_date_info();
		
		cd.setDateUuid(date_uuid);
		cd.setFamilyUuid(family_uuid);
		cd.setChildUuid(child_uuid);
		
//		return classDateRepository.exists(cd);
		return (long) 0;
	}

	
}