package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Hours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends JpaRepository<Hours, Integer> {

}
