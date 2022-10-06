package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.CalendarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarStatusRepository extends JpaRepository<CalendarStatus, Integer> {
}
