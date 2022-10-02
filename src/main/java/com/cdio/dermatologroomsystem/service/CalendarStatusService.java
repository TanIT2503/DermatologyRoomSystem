package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.CalendarStatus;

import java.util.List;

public interface CalendarStatusService {
	List<CalendarStatus> findAll();
	CalendarStatus findById(int cal_status_id);
}
