package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.CalendarStatus;
import com.cdio.dermatologroomsystem.service.CalendarStatusService;
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
@RequestMapping("/api/calendar-status")
public class CalendarStatusRestController {
	@Autowired
	private CalendarStatusService calendarStatusService;

	@GetMapping
	public ResponseEntity<List<CalendarStatus>> findAll() {
		List<CalendarStatus> calendarStatuses = calendarStatusService.findAll();
		if (calendarStatuses.isEmpty()) {
			return new ResponseEntity<List<CalendarStatus>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CalendarStatus>>(calendarStatuses, HttpStatus.OK);
	}
}
