package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.CalendarStatus;
import com.cdio.dermatologroomsystem.entity.DoctorCalendar;
import com.cdio.dermatologroomsystem.service.DoctorCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/doctor-calendar")
public class DoctorCalendarRestController {
	@Autowired
	private DoctorCalendarService doctorCalendarService;

	@GetMapping
	public ResponseEntity<List<DoctorCalendar>> findAll() {
		List<DoctorCalendar> doctorCalendars = doctorCalendarService.findAll();
		if (doctorCalendars.isEmpty()) {
			return new ResponseEntity<List<DoctorCalendar>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<DoctorCalendar>>(doctorCalendars, HttpStatus.OK);
	}
}
