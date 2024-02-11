package com.co.thedots.controller.model;

import java.util.HashMap;
import java.util.Map;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SearchCancelVo {
   
    private String store_name;
    
    private String class_name;
    
    private String reservation_uuid;
    
    private String date_uuid;
    
    private String child_uuid;
    
    private String family_uuid;
    
    private String status;
}

