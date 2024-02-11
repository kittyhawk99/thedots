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
import com.co.thedots.entity.Store_info;
import com.co.thedots.service.repository.ChildRepository;
import com.co.thedots.service.repository.ClassDateRepository;
import com.co.thedots.service.repository.ClassRepository;
import com.co.thedots.service.repository.FamilyRepository;
import com.co.thedots.service.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final StoreRepository storeRepository;
    
    
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}
    
	public Store_info findOne(String store_uuid) {
		// TODO Auto-generated method stub
		return storeRepository.getById(store_uuid);
	}


    
    
}