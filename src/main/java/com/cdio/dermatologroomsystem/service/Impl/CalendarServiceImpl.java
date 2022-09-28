package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Calendar;
import com.cdio.dermatologroomsystem.repository.CalenderRepository;
import com.cdio.dermatologroomsystem.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalendarService {
    @Autowired
    private CalenderRepository calenderRepository;

    @Override
    public List<Calendar> findAllByTime(String cal_time) {
        return calenderRepository.findAllByTime(cal_time);
    }

    @Override
    public Calendar add(Calendar calendar) {
        return calenderRepository.save(calendar);
    }

    @Override
    public void delete(int id) {
        Calendar calendar = calenderRepository.findById(id).orElse(null);
        if (calendar!=null){
            calenderRepository.delete(calendar);
        }
    }

    @Override
    public Calendar update(Calendar calendar) {
        return calenderRepository.save(calendar);
    }

    @Override
    public Calendar findById(int id) {
        return calenderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Calendar> findAll() {
        return calenderRepository.findAll();
    }
}
