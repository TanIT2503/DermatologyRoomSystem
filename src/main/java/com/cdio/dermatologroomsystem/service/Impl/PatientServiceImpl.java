package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.repository.PatientRepository;
import com.cdio.dermatologroomsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findAllByName(String pa_name) {
        return patientRepository.findAllByName(pa_name);
    }

    @Override
    public Patient add(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void delete(int id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient!=null){
            patientRepository.delete(patient);
        }
    }

    @Override
    public Patient update(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(int id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patient -> patients.add(patient));
        return patients;
    }
}
