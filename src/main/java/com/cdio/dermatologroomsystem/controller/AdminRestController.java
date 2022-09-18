package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.service.AdminService;
import com.cdio.dermatologroomsystem.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class AdminRestController {
	@Autowired
	AdminService adminService;

	@Autowired
	MedicalService medicalService;

	@GetMapping("/admin/api/list")
	public List<Admin> list(){
		return adminService.findAll();
	}

	@GetMapping("/admin/api/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id){
		try {
			Admin admin = adminService.findById(id);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		} catch (NoSuchElementException e){
			return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/admin/api/create")
	public void createAdmin(@RequestBody Admin admin){
		adminService.create(admin);
	}
}
