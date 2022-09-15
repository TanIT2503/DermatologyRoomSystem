package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.repository.AdminRepository;
import com.cdio.dermatologroomsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public List<Admin> findAll() {

		return adminRepository.findAll();
	}

	@Override
	public void create(Admin admin) {
		adminRepository.save(admin);
	}

	@Override
	public List<Admin> findAllByName(String adminName) {
		return null;
	}

	@Override
	public void update(Admin admin) {

	}

	@Override
	public void delete(int adminId) {

	}

	@Override
	public Admin findById(int adminId) {
		return null;
	}
}
