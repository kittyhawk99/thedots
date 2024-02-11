package com.co.thedots.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name= "class_date_info")
public class Class_date_info {
	

//  
	@Id
	@Column(name="date_uuid")
    private String dateUuid;
    
    @Column(name="class_uuid")
    private String classUuid;

    @Column(name="family_uuid")
    private String familyUuid;

    
    @Column(name="child_uuid")
    private String childUuid;
    
    @Column(name="class_date")
    private String classDate;    
  
    @Column(name="class_start_time")
    private String classStartTime;
    
    @Column(name="class_end_time")
    private String classEndTime;
    
    @Column(name="max_number")
    private int maxNumber;

    @Column(name="create_date")
    private String createDate;
    
    @Column(name="update_date")
    private String updateDate;

	public String getDateUuid() {
		return dateUuid;
	}

	public void setDateUuid(String dateUuid) {
		this.dateUuid = dateUuid;
	}

	public String getClassUuid() {
		return classUuid;
	}

	public void setClassUuid(String classUuid) {
		this.classUuid = classUuid;
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

	public String getClassDate() {
		return classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public String getClassStartTime() {
		return classStartTime;
	}

	public void setClassStartTime(String classStartTime) {
		this.classStartTime = classStartTime;
	}

	public String getClassEndTime() {
		return classEndTime;
	}

	public void setClassEndTime(String classEndTime) {
		this.classEndTime = classEndTime;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
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
 
    
    
    
}
