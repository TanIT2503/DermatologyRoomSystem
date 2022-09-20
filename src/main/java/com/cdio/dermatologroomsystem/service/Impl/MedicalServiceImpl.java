package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.entity.Medical;
import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.repository.MedicalRepository;
import com.cdio.dermatologroomsystem.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {
	@Autowired
	private MedicalRepository medicalRepository;


	@Override
	public List<Medical> findAll() {
		List<Medical> medicals = new ArrayList<>();
		medicalRepository.findAll().forEach(medical -> medicals.add(medical));
		return medicals;
	}

	@Override
	public Medical create(Medical medical) {
		return medicalRepository.save(medical);
	}


	@Override
	public Medical update(Medical medical) {
		return medicalRepository.save(medical);
	}

	@Override
	public void delete(int medicalId) {
		Medical medical = medicalRepository.findById(medicalId).orElse(null);
		if (medical!=null){
			medicalRepository.delete(medical);
		}
	}

	@Override
	public Medical findById(int medicalId) {
		return medicalRepository.findById(medicalId).orElse(null);
	}

	@Override
	public List<Medical> findAllByName(String medicalName) {
		return medicalRepository.findAllByName(medicalName);
	}
}
