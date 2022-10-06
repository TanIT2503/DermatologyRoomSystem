package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Hours;
import com.cdio.dermatologroomsystem.repository.HoursRepository;
import com.cdio.dermatologroomsystem.service.HoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoursServiceImpl implements HoursService {
	@Autowired
	private HoursRepository hoursRepository;
	@Override
	public List<Hours> findAll() {
		return hoursRepository.findAll();
	}

	@Override
	public Hours findById(int hours_id) {
		return hoursRepository.findById(hours_id).orElse(null);
	}
}
