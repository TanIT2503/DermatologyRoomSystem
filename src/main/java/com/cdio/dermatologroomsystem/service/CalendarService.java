package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Calendar;

import java.util.List;

public interface CalendarService {
    List<Calendar> findAllByTime(String cal_time);
    Calendar add(Calendar calendar);
    void delete(int id);
    Calendar update(Calendar calendar);
    Calendar findById(int id);

    List<Calendar> findAll();
}
