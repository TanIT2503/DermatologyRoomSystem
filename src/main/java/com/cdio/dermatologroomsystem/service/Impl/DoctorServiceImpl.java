package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Doctor;
import com.cdio.dermatologroomsystem.entity.Medical;
import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.repository.DoctorRepository;
import com.cdio.dermatologroomsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public Doctor add(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public void delete(int id) {
		Doctor doctor = doctorRepository.findById(id).orElse(null);
		if (doctor!=null){
			doctorRepository.delete(doctor);
		}
	}

	@Override
	public Doctor update(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor findById(int id) {
		return doctorRepository.findById(id).orElse(null);
	}

	@Override
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}
}
