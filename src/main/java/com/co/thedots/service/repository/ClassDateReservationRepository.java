package com.co.thedots.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.thedots.entity.Class_date_info;
import com.co.thedots.entity.Class_date_reservation_info;
import com.co.thedots.entity.Store_info;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public interface ClassDateReservationRepository extends JpaRepository<Class_date_reservation_info, String>{

	public static final JPAQueryFactory jpaQueryFactory = null;
	
	void save(Class_date_info cd);

	Class_date_reservation_info findByReservationUuid(String reservation_uuid);

	List<Class_date_reservation_info> findByClassDate(String class_date);

	
}
