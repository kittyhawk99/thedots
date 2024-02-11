package com.co.thedots.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Store_info {
	

//  
	@Id
	@Column(name="store_uuid")
    private String storeUuid;
    
    @Column(name="store_name")
    private String storeName;
    
    @Column(name="post_code")
    private String postCode;
  
    @Column(name="addr1")
    private String addr1;
    
    @Column(name="addr2")
    private String addr2;
    
    @Column(name="addr3")
    private String addr3;

    @Column(name="create_date")
    private String createDate;
    
    @Column(name="update_date")
    private String updateDate;
 
    
}
