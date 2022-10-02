package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.DoctorCalendar;
import com.cdio.dermatologroomsystem.entity.Medical;
import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.repository.DoctorCalendarRepository;
import com.cdio.dermatologroomsystem.service.DoctorCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorCalendarServiceImpl implements DoctorCalendarService {

	@Autowired
	private DoctorCalendarRepository doctorCalendarRepository;
	@Override
	public List<DoctorCalendar> findAll() {
		return doctorCalendarRepository.findAll();
	}

	@Override
	public DoctorCalendar add(DoctorCalendar doctorCalendar) {
		return doctorCalendarRepository.save(doctorCalendar);
	}

	@Override
	public void delete(int id) {
		DoctorCalendar doctorCalendar = doctorCalendarRepository.findById(id).orElse(null);
		if (doctorCalendar!=null){
			doctorCalendarRepository.delete(doctorCalendar);
		}
	}

	@Override
	public DoctorCalendar update(DoctorCalendar doctorCalendar) {
		return doctorCalendarRepository.save(doctorCalendar);
	}

	@Override
	public DoctorCalendar findById(int id) {
		return doctorCalendarRepository.findById(id).orElse(null);
	}
}
