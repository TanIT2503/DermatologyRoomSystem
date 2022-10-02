package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Doctor;
import com.cdio.dermatologroomsystem.entity.Patient;

import java.util.List;

public interface DoctorService {
	Doctor add(Doctor doctor);
	void delete(int id);
	Doctor update(Doctor doctor);
	public Doctor findById(int id);
	List<Doctor> findAll();
}
