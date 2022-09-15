package com.cdio.dermatologroomsystem.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String adminId;
	private String adminName;
	@DateTimeFormat(pattern = "yyyy-MM-dddd")
	private Date adminBirthday;
	private boolean adminGender;
	private String adminAddress;
	private String adminNumberPhone;
	private String adminEmail;
	private String adminIdCard;
	private String UserName;

	@ManyToOne(targetEntity = Medical.class)
	private Medical medicalId;

	public Admin() {
	}

	public Admin(String adminId , String adminName , Date adminBirthday , boolean adminGender , String adminAddress , String adminNumberPhone , String adminEmail , String adminIdCard , String userName , Medical medicalId) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminBirthday = adminBirthday;
		this.adminGender = adminGender;
		this.adminAddress = adminAddress;
		this.adminNumberPhone = adminNumberPhone;
		this.adminEmail = adminEmail;
		this.adminIdCard = adminIdCard;
		UserName = userName;
		this.medicalId = medicalId;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Date getAdminBirthday() {
		return adminBirthday;
	}

	public void setAdminBirthday(Date adminBirthday) {
		this.adminBirthday = adminBirthday;
	}

	public boolean isAdminGender() {
		return adminGender;
	}

	public void setAdminGender(boolean adminGender) {
		this.adminGender = adminGender;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminNumberPhone() {
		return adminNumberPhone;
	}

	public void setAdminNumberPhone(String adminNumberPhone) {
		this.adminNumberPhone = adminNumberPhone;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminIdCard() {
		return adminIdCard;
	}

	public void setAdminIdCard(String adminIdCard) {
		this.adminIdCard = adminIdCard;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Medical getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(Medical medicalId) {
		this.medicalId = medicalId;
	}
}
