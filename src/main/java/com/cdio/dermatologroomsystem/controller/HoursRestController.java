package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Hours;
import com.cdio.dermatologroomsystem.service.HoursService;
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
@RequestMapping("/api/hours")
public class HoursRestController {
	@Autowired
	private HoursService hoursService;

	@GetMapping
	public ResponseEntity<List<Hours>> findAll() {
		List<Hours> hoursList = hoursService.findAll();
		if (hoursList.isEmpty()) {
			return new ResponseEntity<List<Hours>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hours>>(hoursList, HttpStatus.OK);
	}
}
