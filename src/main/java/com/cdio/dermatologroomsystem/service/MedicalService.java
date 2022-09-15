package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.entity.Medical;

import java.util.List;

public interface MedicalService {
	List<Medical> findAll();
	void create(Medical medical);
	void update(Medical medical);
	void delete(int medicalId);
	Medical findById(int medicalId);
}
