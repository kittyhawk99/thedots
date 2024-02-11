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
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.co.thedots.controller.model.SearchVo;
import com.co.thedots.entity.Class_date_info;
import com.co.thedots.entity.Class_date_reservation_info;
import com.co.thedots.entity.Store_info;
import com.co.thedots.service.repository.ChildRepository;
import com.co.thedots.service.repository.ClassDateRepository;
import com.co.thedots.service.repository.ClassDateReservationRepository;
import com.co.thedots.service.repository.ClassRepository;
import com.co.thedots.service.repository.FamilyRepository;
import com.co.thedots.service.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassDateReservationService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final ClassDateReservationRepository classDateReservationRepository;
   
	public ClassDateReservationService(ClassDateReservationRepository classDateReservationRepository) {
		this.classDateReservationRepository = classDateReservationRepository;
	}
	
	public void insertClassDate(String date_uuid, String family_uuid, String child_uuid) {
		
		Class_date_info cd = new Class_date_info();
		
		cd.setDateUuid(date_uuid);
		cd.setFamilyUuid(family_uuid);
		cd.setChildUuid(child_uuid);
		
		classDateReservationRepository.save(cd);
	}

	public Class_date_reservation_info findClassReservation_uuid(String reservation_uuid) {
		// TODO Auto-generated method stub
		return classDateReservationRepository.findByReservationUuid(reservation_uuid);
	}

	public void updateClassDate(String date_uuid, String family_uuid, String child_uuid, String reservation_uuid) {
		Class_date_reservation_info cd = new Class_date_reservation_info();
		
		cd.setDateUuid(date_uuid);
		cd.setFamilyUuid(family_uuid);
		cd.setChildUuid(child_uuid);
		cd.setReservationUuid(reservation_uuid);
		
		classDateReservationRepository.save(cd);
		
	}    
	
	public List<Class_date_reservation_info> findAll(String class_date, String family_uuid, String child_uuid) {
		
		Class_date_reservation_info cd = new Class_date_reservation_info();
		
		cd.setDateUuid(class_date);
		cd.setStatus("complete");
		
		return classDateReservationRepository.findAll((Example<Class_date_reservation_info>) cd);
	}
	
	public List<Class_date_reservation_info> findAllLogList(String class_date, String family_uuid, String child_uuid) {
		
		Class_date_reservation_info cd = new Class_date_reservation_info();
		
		cd.setDateUuid(class_date);
		
		return classDateReservationRepository.findByClassDate(class_date);
	}
		
	
	
}