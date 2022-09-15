package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Calendar;
import com.cdio.dermatologroomsystem.repository.CalenderRepository;
import com.cdio.dermatologroomsystem.service.CalenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceImpl implements CalenderService {
    @Autowired
    private CalenderRepository calenderRepository;

    @Override
    public List<Calendar> findAllByTime(String time) {
        return calenderRepository.findAllByTime(time);
    }

    @Override
    public void add(Calendar calendar) {
        calenderRepository.save(calendar);
    }

    @Override
    public void delete(int id) {
        Calendar calendar = calenderRepository.findById(id).orElse(null);
        if (calendar!=null){
            calenderRepository.save(calendar);
        }
    }

    @Override
    public void update(Calendar calendar) {
        calenderRepository.save(calendar);
    }

    @Override
    public Calendar findById(int id) {
        return calenderRepository.findById(id).orElse(null);
    }
}
