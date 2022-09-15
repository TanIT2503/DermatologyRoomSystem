package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.entity.Medical;
import com.cdio.dermatologroomsystem.repository.MedicalRepository;
import com.cdio.dermatologroomsystem.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {
	@Autowired
	private MedicalRepository medicalRepository;


	@Override
	public List<Medical> findAll() {
		return medicalRepository.findAll();
	}

	@Override
	public void create(Medical medical) {

	}


	@Override
	public void update(Medical medical) {

	}

	@Override
	public void delete(int medicalId) {

	}

	@Override
	public Medical findById(int medicalId) {
		return null;
	}
}
