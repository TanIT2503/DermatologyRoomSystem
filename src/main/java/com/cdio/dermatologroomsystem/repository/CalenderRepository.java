package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Calendar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalenderRepository extends JpaRepository<Calendar, Integer> {
    @Query(value = "select * from CALENDAR where cal_time = :cal_time", nativeQuery = true, countQuery = "select * from CALENDAR where (cal_time = :cal_time) xyz")
    List<Calendar> findAllByTime(String cal_time);

    @Query(value = "select cal.cal_id, cal.cal_date, cal.pa_id, s.cal_status_id, s.cal_status_name from calendar as cal join calendar_status as s on cal.cal_status_id = s.cal_status_id where cal.pa_id=?1", nativeQuery = true)
    List<Calendar> findByPatientId(Integer pa_id);
}
