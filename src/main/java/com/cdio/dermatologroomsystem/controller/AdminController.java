package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.dto.AdminDto;
import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.entity.Medical;
import com.cdio.dermatologroomsystem.service.AdminService;
import com.cdio.dermatologroomsystem.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@Autowired
	MedicalService medicalService;

	@ModelAttribute

	@GetMapping("/list")
	public String showAdminList(Model model){
		List<Admin> adminList = adminService.findAll();
		model.addAttribute("admins", adminList);
		return "/admin/list";
	}

	@GetMapping("/create")
	public String create(Model model){
		AdminDto adminDto = new AdminDto();
		adminDto.setMedicalId(new Medical());
		model.addAttribute("adminDto", adminDto);
		model.addAttribute("medical", medicalService.findAll());
		return "/admin/create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute("admin") Admin admin, Model model){
		adminService.create(admin);
		return "redirect:/admin/list";
	}
}
