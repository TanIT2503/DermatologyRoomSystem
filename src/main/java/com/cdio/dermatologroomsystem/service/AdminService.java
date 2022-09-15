package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Admin;

import java.util.List;

public interface AdminService {
	List<Admin> findAll();
	void create(Admin admin);
	List<Admin> findAllByName(String adminName);
	void update(Admin admin);
	void delete(String adminId);
	Admin findById(String adminId);
}
