package com.cdio.dermatologroomsystem.dto;

import com.cdio.dermatologroomsystem.entity.Medical;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import java.util.Date;

public class AdminDto {
	private int adminId;
	private String adminName;
	@DateTimeFormat(pattern = "yyyy-MM-dddd")
	private Date adminBirthday;
	private boolean adminGender;
	private String adminAddress;
	private String adminNumberPhone;
	private String adminEmail;
	private String adminIdCard;
	private String UserName;
	private Medical medicalId;

	public AdminDto() {
	}

	public AdminDto(int adminId , String adminName , Date adminBirthday , boolean adminGender , String adminAddress , String adminNumberPhone , String adminEmail , String adminIdCard , String userName , Medical medicalId) {
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

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
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
