package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicalRepository extends JpaRepository<Admin, String> {
	@Query(value = "SELECT * FROM MEDICAL WHERE (ad_name like concat('%', :ad_name, '%'))", nativeQuery = true)
	List<Admin> findAllByName(@Param("ad_name") String adminName);
}
