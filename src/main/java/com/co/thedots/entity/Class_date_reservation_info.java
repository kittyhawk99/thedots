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
public class Class_date_reservation_info {
	

//  
	@Id
	@Column(name="reservation_uuid")
    private String reservationUuid;
    
    @Column(name="date_uuid")
    private String dateUuid;

    @Column(name="family_uuid")
    private String familyUuid;
    
    @Column(name="child_uuid")
    private String childUuid;
    
    @Column(name="status")
    private String status;    
  
    @Column(name="create_date")
    private String createDate;
    
    @Column(name="update_date")
    private String updateDate;

    @Column(name="class_date")
    private String classDate;    
    
	public String getReservationUuid() {
		return reservationUuid;
	}

	public void setReservationUuid(String reservationUuid) {
		this.reservationUuid = reservationUuid;
	}

	public String getDateUuid() {
		return dateUuid;
	}

	public void setDateUuid(String dateUuid) {
		this.dateUuid = dateUuid;
	}

	public String getFamilyUuid() {
		return familyUuid;
	}

	public void setFamilyUuid(String familyUuid) {
		this.familyUuid = familyUuid;
	}

	public String getChildUuid() {
		return childUuid;
	}

	public void setChildUuid(String childUuid) {
		this.childUuid = childUuid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

    
    
}
