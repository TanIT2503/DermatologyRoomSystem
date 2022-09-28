package com.cdio.dermatologroomsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class CalendarStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cal_status_id;
	private String cal_status_name;
	@OneToMany(mappedBy = "cal_status",fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Calendar> calendarList = new ArrayList<>();
}
