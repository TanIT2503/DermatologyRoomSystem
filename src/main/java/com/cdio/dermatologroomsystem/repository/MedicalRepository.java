package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Admin;
import com.cdio.dermatologroomsystem.entity.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicalRepository extends JpaRepository<Medical, Integer> {
	@Query("SELECT m FROM Medical m WHERE (m.medicalName like concat('%',:medicalName, '%'))")
	List<Medical> findAllByName(String medicalName);
}
