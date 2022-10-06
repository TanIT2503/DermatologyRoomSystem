package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class DoctorCalendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doc_cal_id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
	@JsonBackReference
	private Doctor doctor_id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "hours_id", referencedColumnName = "hours_id")
	private Hours hours_id;

	public DoctorCalendar() {
	}

	public int getDoc_cal_id() {
		return doc_cal_id;
	}

	public void setDoc_cal_id(int doc_cal_id) {
		this.doc_cal_id = doc_cal_id;
	}

	public Doctor getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(Doctor doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Hours getHours_id() {
		return hours_id;
	}

	public void setHours_id(Hours hours_id) {
		this.hours_id = hours_id;
	}
}
