package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/patient")
public class PatientRestController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> findAll(){
        List<Patient> patientList = patientService.findAll();
        if (patientList.isEmpty()) {
            return new ResponseEntity<List<Patient>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Patient>>(patientList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable("id") Integer id){
        try{
            Patient patient = patientService.findById(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.add(patient), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Integer id, @RequestBody Patient patient){
        Patient patientFind = patientService.findById(id);
        try{
            patient.setPa_id(patientFind.getPa_id());
            return new ResponseEntity<Patient>(patientService.update(patient), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable("id") Integer id){
        try{
            Patient patient = patientService.findById(id);
            patientService.delete(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }
}
