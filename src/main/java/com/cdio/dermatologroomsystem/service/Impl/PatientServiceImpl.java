package com.cdio.dermatologroomsystem.service.Impl;

import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.entity.Role;
import com.cdio.dermatologroomsystem.repository.AccountRepository;
import com.cdio.dermatologroomsystem.repository.PatientRepository;
import com.cdio.dermatologroomsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Patient> findAllByName(String pa_name) {
        return patientRepository.findAllByName(pa_name);
    }

    @Override
    public Patient add(Patient patient) {
        patientRepository.save(patient);
        Set<Role> roleSet = new HashSet<>();
        Role role = new Role();
        role.setRole_id(3);
        roleSet.add(role);
        patient.getAccount().setRoles(roleSet);
        accountRepository.save(patient.getAccount());
        patientRepository.save(patient);
        return patient;
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
