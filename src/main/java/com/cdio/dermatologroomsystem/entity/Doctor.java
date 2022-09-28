package com.cdio.dermatologroomsystem.entity;

import javax.persistence.*;

@Entity
@Table
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;
	private String doctor_name;
	private String doctor_birthday;
	private boolean doctor_gender;
	private String doctor_address;
	private String doctor_phone;
	private String doctor_id_card;
	private String doctor_email;
	private String username;
}
