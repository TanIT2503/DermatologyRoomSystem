package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.DoctorCalendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorCalendarRepository extends JpaRepository<DoctorCalendar, Integer> {

}
