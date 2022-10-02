package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.DoctorCalendar;
import com.cdio.dermatologroomsystem.entity.Patient;

import java.util.List;

public interface DoctorCalendarService {
	List<DoctorCalendar> findAll();
	DoctorCalendar add(DoctorCalendar doctorCalendar);
	void delete(int id);
	DoctorCalendar update(DoctorCalendar doctorCalendar);
	public DoctorCalendar findById(int id);
//	List<DoctorCalendar> findAll();
}
