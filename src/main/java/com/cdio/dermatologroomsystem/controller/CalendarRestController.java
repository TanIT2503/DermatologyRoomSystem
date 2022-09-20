package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Calendar;
import com.cdio.dermatologroomsystem.entity.Calendar;
import com.cdio.dermatologroomsystem.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/calendar")
public class CalendarRestController {
    @Autowired
    private CalendarService calenderService;

    @GetMapping
    public ResponseEntity<List<Calendar>> findAll() {
        List<Calendar> calendarList = calenderService.findAll();
        if (calendarList.isEmpty()) {
            return new ResponseEntity<List<Calendar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Calendar>>(calendarList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Calendar>> searchByTime(@RequestParam String cal_time) {
        List<Calendar> calendarList = calenderService.findAllByTime(cal_time);
        if (calendarList.isEmpty()) {
            return new ResponseEntity<List<Calendar>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Calendar>>(calendarList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calendar> findCalendarById(@PathVariable("id") Integer id){
        try{
            Calendar Calendar = calenderService.findById(id);
            return new ResponseEntity<Calendar>(Calendar, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Calendar>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Calendar> saveCalendar(@RequestBody Calendar calendar){
        return new ResponseEntity<>(calenderService.add(calendar), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Calendar> updateCalendar(@PathVariable("id") Integer id, @RequestBody Calendar calendar){
        Calendar calendarFind = calenderService.findById(id);
        try{
            calendar.setCal_id(calendarFind.getCal_id());
            return new ResponseEntity<Calendar>(calenderService.update(calendar), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Calendar>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Calendar> deleteCalendar(@PathVariable("id") Integer id){
        try{
            Calendar calendar = calenderService.findById(id);
            calenderService.delete(id);
            return new ResponseEntity<Calendar>(calendar, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Calendar>(HttpStatus.NOT_FOUND);
        }
    }
}
