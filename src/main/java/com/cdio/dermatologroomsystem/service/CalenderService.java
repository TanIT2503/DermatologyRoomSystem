package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Calendar;
import com.cdio.dermatologroomsystem.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CalenderService {
    List<Calendar> findAllByTime(String time);
    void add(Calendar calendar);
    void delete(int id);
    void update(Calendar calendar);
    Calendar findById(int id);
}
