package com.co.thedots.controller;

import java.security.NoSuchProviderException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.extern.log4j.Log4j2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.thedots.controller.model.SearchCancelVo;
import com.co.thedots.controller.model.SearchVo;
import com.co.thedots.entity.Store_info;
import com.co.thedots.entity.commonVo;
import com.co.thedots.entity.Class_date_info;
import com.co.thedots.entity.Class_date_reservation_info;
import com.co.thedots.service.ClassDateReservationService;
import com.co.thedots.service.ClassDateService;
import com.co.thedots.service.StoreService;
import com.co.thedots.service.repository.ChildRepository;
import com.co.thedots.service.repository.ClassDateRepository;
import com.co.thedots.service.repository.ClassRepository;
import com.co.thedots.service.repository.FamilyRepository;
import com.co.thedots.service.repository.StoreRepository;

@Log4j2
@RestController
public class HomeController implements CommonController {

	private StoreService storeService;
	
	private ClassDateService classDateService;
	
	private ClassDateReservationService classDateReservationService;
	
	private final StoreRepository storeRepository;
	private final ClassRepository classRepository;
	private final ClassDateRepository classDateRepository;
	private final FamilyRepository familyRepository;
	private final ChildRepository childRepository;
	
	public HomeController(StoreRepository storeRepository, 
						ClassRepository classRepository,
						ClassDateRepository classDateRepository,
						FamilyRepository familyRepository,
						ChildRepository childRepository) {
		this.storeRepository = storeRepository;
		this.classRepository = classRepository;		
		this.classDateRepository = classDateRepository;
		this.familyRepository = familyRepository;
		this.childRepository = childRepository;
	}
	
	@RequestMapping(value = "/test")
    public ResponseEntity<commonVo> test(HttpServletRequest request, HttpServletResponse response) throws NoSuchProviderException {
	
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
	    //emf.close();
		
		List<Store_info> store_info = storeRepository.findAll();
		
		store_info.forEach(s -> {
			System.out.println("store_info==="+s.toString());
		});
		
		
		responseData.put("data", null); 
		
		commonVo resp = null;
		
        return new ResponseEntity<commonVo>(resp, httpHeaders, HttpStatus.OK);
	}   
	
	@RequestMapping(value = "/reservation")
    public ResponseEntity<commonVo> reservation(
    		@ModelAttribute SearchVo searchVo) throws NoSuchProviderException {
		
		commonVo comm = new commonVo();
		
		// 매장 아이디
		String store_uuid = "";
		// 수업 일자
		String class_date = "";
		
		String family_uuid = "";
		
		String child_uuid = "";
		
		
		//  1. 매장 선택
		Store_info store_info = storeService.findOne(store_uuid);
		
		//  2. 수업 선택
		Class_date_info class_date_info = classDateService.findClassOne(class_date);
		
		// 3. 예약 완료
		//Long res_date_count = classDateService.exists(class_date_info.getDate_uuid(), family_uuid, child_uuid );
		
		Long res_date_count = (long) 0;
		
		// 기존 예약 여부 체크		
		if(res_date_count <= 0){
			
			//  예약 정보 저장
			classDateReservationService.insertClassDate(class_date_info.getDateUuid(), family_uuid, child_uuid);
			
		}else {
			 comm = new commonVo("reservation error1", "기존 예약 건이 있음", null);
		}
		
        return new ResponseEntity<commonVo>(comm, httpHeaders, HttpStatus.OK);
	}   
	
	@RequestMapping(value = "/reservationCancel")
    public ResponseEntity<commonVo> reservationCancel(
    		@ModelAttribute SearchCancelVo searchVo) throws NoSuchProviderException {
		
		commonVo comm = new commonVo();
		
		// 매장 아이디
		String store_uuid = "";
		// 수업 일자
		String class_date = "";
		
		String family_uuid = "";
		
		String child_uuid = "";
		
		String reservation_uuid = "";
		

		//  1. 예약 정보 여부 체크
		Class_date_reservation_info class_date_reservation_info = classDateReservationService.findClassReservation_uuid(reservation_uuid);
				
		// 기존 예약 여부 체크		
		if(class_date_reservation_info != null){
			
			//  예약 정보 저장 (취소)
			classDateReservationService.updateClassDate(class_date_reservation_info.getDateUuid(), family_uuid, child_uuid, class_date_reservation_info.getReservationUuid());
			
		}else {
			 comm = new commonVo("reservation error1", "기존 예약 건이 없음", null);
		}
		
        return new ResponseEntity<commonVo>(comm, httpHeaders, HttpStatus.OK);
	}   
	
	/**
	 * 예약자 현황 api
	 * @param searchVo
	 * @return
	 * @throws NoSuchProviderException
	 */
	@RequestMapping(value = "/reservationList")
    public ResponseEntity<commonVo> reservationList(
    		@ModelAttribute SearchCancelVo searchVo) throws NoSuchProviderException {
		
		commonVo comm = new commonVo();
		
		// 매장 아이디
		String store_uuid = "";
		// 수업 일자
		String class_date = "";
		
		String family_uuid = "";
		
		String child_uuid = "";
		
		String reservation_uuid = "";
		

		//  1. 예약 정보 여부 체크
		List<Class_date_reservation_info> class_date_reservation_info = classDateReservationService.findAll(class_date, family_uuid, child_uuid);
		
		comm = new commonVo("reservation error1", "기존 예약 건이 없음", null, class_date_reservation_info);
		
        return new ResponseEntity<commonVo>(comm, httpHeaders, HttpStatus.OK);
	}   
	
	/**
	 * 예약자 로그 현황 api
	 * @param searchVo
	 * @return
	 * @throws NoSuchProviderException
	 */
	@RequestMapping(value = "/reservationLogList")
    public ResponseEntity<commonVo> reservationLogList(
    		@ModelAttribute SearchCancelVo searchVo) throws NoSuchProviderException {
		
		commonVo comm = new commonVo();
		
		// 매장 아이디
		String store_uuid = "";
		// 수업 일자
		String class_date = "";
		
		String family_uuid = "";
		
		String child_uuid = "";
		
		String reservation_uuid = "";
		

		//  1. 예약 정보 여부 체크
		List<Class_date_reservation_info> class_date_reservation_info = classDateReservationService.findAllLogList(class_date, family_uuid, child_uuid);
		
		comm = new commonVo("reservation error1", "기존 예약 건이 없음", null, class_date_reservation_info);
		
        return new ResponseEntity<commonVo>(comm, httpHeaders, HttpStatus.OK);
	}   
	
	
}
