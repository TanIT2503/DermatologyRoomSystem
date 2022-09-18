package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query(value = "SELECT * FROM ADMIN WHERE (ad_name like concat('%', :ad_name, '%'))", nativeQuery = true)
	List<Admin> findAll(@Param("ad_name") String adminName);

}
