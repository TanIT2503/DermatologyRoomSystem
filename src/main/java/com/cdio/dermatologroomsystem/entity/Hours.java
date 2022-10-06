package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Hours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hours_id;
	private String hours;
	@OneToMany(mappedBy = "hours_id",fetch = FetchType.EAGER)
	@JsonBackReference
	private List<DoctorCalendar> doctorCalendars = new ArrayList<>();

	public Hours() {
	}

	public int getHours_id() {
		return hours_id;
	}

	public void setHours_id(int hours_id) {
		this.hours_id = hours_id;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public List<DoctorCalendar> getDoctorCalendars() {
		return doctorCalendars;
	}

	public void setDoctorCalendars(List<DoctorCalendar> doctorCalendars) {
		this.doctorCalendars = doctorCalendars;
	}
}
