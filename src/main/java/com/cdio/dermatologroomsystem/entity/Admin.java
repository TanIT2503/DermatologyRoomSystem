package com.cdio.dermatologroomsystem.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	@DateTimeFormat(pattern = "yyyy-MM-dddd")
	private Date adminBirthday;
	private boolean adminGender;
	private String adminAddress;
	private String adminNumberPhone;
	private String adminEmail;
	private String adminIdCard;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	private Account account;



	public Admin() {
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
