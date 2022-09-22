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

}
