package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Hours;

import java.util.List;

public interface HoursService {
	List<Hours> findAll();
	Hours findById(int hours_id);
}
