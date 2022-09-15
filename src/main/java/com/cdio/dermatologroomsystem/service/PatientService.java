package com.cdio.dermatologroomsystem.service;

import com.cdio.dermatologroomsystem.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    List<Patient> findAllByName(String name);
    void add(Patient patient);
    void delete(int id);
    void update(Patient patient);
    public Patient findById(int id);
}
