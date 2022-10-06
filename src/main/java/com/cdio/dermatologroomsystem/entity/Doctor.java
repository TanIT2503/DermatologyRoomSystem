package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "doctor")
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

	@OneToMany(mappedBy = "doctor_id",fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<DoctorCalendar> doctorCalendars = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	@JsonManagedReference
	private Account account;

	public Doctor() {
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDoctor_birthday() {
		return doctor_birthday;
	}

	public void setDoctor_birthday(String doctor_birthday) {
		this.doctor_birthday = doctor_birthday;
	}

	public boolean isDoctor_gender() {
		return doctor_gender;
	}

	public void setDoctor_gender(boolean doctor_gender) {
		this.doctor_gender = doctor_gender;
	}

	public String getDoctor_address() {
		return doctor_address;
	}

	public void setDoctor_address(String doctor_address) {
		this.doctor_address = doctor_address;
	}

	public String getDoctor_phone() {
		return doctor_phone;
	}

	public void setDoctor_phone(String doctor_phone) {
		this.doctor_phone = doctor_phone;
	}

	public String getDoctor_id_card() {
		return doctor_id_card;
	}

	public void setDoctor_id_card(String doctor_id_card) {
		this.doctor_id_card = doctor_id_card;
	}

	public String getDoctor_email() {
		return doctor_email;
	}

	public void setDoctor_email(String doctor_email) {
		this.doctor_email = doctor_email;
	}

	public List<DoctorCalendar> getDoctorCalendars() {
		return doctorCalendars;
	}

	public void setDoctorCalendars(List<DoctorCalendar> doctorCalendars) {
		this.doctorCalendars = doctorCalendars;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
