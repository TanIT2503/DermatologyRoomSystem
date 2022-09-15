package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;

	@ModelAttribute

	@GetMapping("/")
	public String showAdminList(Model model){
		List<Admin> adminList = adminService.findAll();
		model.addAttribute("admin", adminList);
		return "/admin/list";
	}

//	@PostMapping("/create")
//	public String create(@ModelAttribute("admin") Admin admin, RedirectAttributes redirectAttributes, Model model){
//		Admin admin
//	}
}
