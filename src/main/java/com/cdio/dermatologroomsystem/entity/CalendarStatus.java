package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "calendar_status")
public class CalendarStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cal_status_id;
	private String cal_status_name;
	@OneToMany(mappedBy = "cal_status",fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Calendar> calendarList = new ArrayList<>();

	public CalendarStatus() {
	}

	public int getCal_status_id() {
		return cal_status_id;
	}

	public void setCal_status_id(int cal_status_id) {
		this.cal_status_id = cal_status_id;
	}

	public String getCal_status_name() {
		return cal_status_name;
	}

	public void setCal_status_name(String cal_status_name) {
		this.cal_status_name = cal_status_name;
	}

	public List<Calendar> getCalendarList() {
		return calendarList;
	}

	public void setCalendarList(List<Calendar> calendarList) {
		this.calendarList = calendarList;
	}
}
