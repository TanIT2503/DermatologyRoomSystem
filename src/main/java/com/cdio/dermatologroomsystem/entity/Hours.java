package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hours")
public class Hours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hours_id;
	private String hours;
	@OneToMany(mappedBy = "hours",fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Calendar> calendarList = new ArrayList<>();

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

	public List<Calendar> getCalendarList() {
		return calendarList;
	}

	public void setCalendarList(List<Calendar> calendarList) {
		this.calendarList = calendarList;
	}
}
