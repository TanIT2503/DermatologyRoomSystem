package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.CalendarStatus;
import com.cdio.dermatologroomsystem.repository.CalendarStatusRepository;
import com.cdio.dermatologroomsystem.service.CalendarStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarStatusServiceImpl implements CalendarStatusService {
	@Autowired
	private CalendarStatusRepository calendarStatusRepository;
	@Override
	public List<CalendarStatus> findAll() {
		return calendarStatusRepository.findAll();
	}

	@Override
	public CalendarStatus findById(int cal_status_id) {
		return calendarStatusRepository.findById(cal_status_id).orElse(null);
	}
}
