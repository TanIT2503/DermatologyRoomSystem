package com.cdio.dermatologroomsystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	private String adminId;
	private String adminName;
	private String adminBirthday;
	private String adminAddress;
	private String adminNumberPhone;
	private String adminEmail;
	private String adminIdCard;
	private String UserName;
}
