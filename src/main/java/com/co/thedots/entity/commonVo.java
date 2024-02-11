package com.co.thedots.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Getter
@AllArgsConstructor
public class commonVo {

    private String reasonCode;
    
    private String reasonCodeText;    
	
    private HashMap<String, Object> payload;
    
    private List<Class_date_reservation_info> reservationList;
    
    public commonVo() {}

    @Builder
	public commonVo( String reasonCode, String reasonCodeText, HashMap<String, Object> payload) {
		// TODO Auto-generated method stub
		this.reasonCode = reasonCode;
		this.reasonCodeText = reasonCodeText;
		this.payload = payload;
	}

    @Builder
	public commonVo( String reasonCode, String reasonCodeText, HashMap<String, Object> payload,  List<Class_date_reservation_info> reservationList) {
		// TODO Auto-generated method stub
		this.reasonCode = reasonCode;
		this.reasonCodeText = reasonCodeText;
		this.payload = payload;
		this.reservationList = reservationList;
	}

    
}


