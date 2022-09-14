package com.cdio.dermatologroomsystem.repository;

import com.cdio.dermatologroomsystem.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    @Query(value = "SELECT * FROM PATIENT where pa_name like concat('%', :pa_name,'%') ", nativeQuery = true,
    countQuery = "SELECT * FROM PATIENT where pa_name like concat('%', :pa_name,'%') abc")
    List<Patient> findAllByName(@Param("pa_name") String pa_name);
}
