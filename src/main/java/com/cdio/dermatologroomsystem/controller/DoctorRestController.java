package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Doctor;
import com.cdio.dermatologroomsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> findAll(){
        List<Doctor> doctors = doctorService.findAll();
        if (doctors.isEmpty()){
            return new ResponseEntity<List<Doctor>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        return new ResponseEntity<Doctor>(doctorService.add(doctor), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable("id") int id){
        try {
            Doctor doctor = doctorService.findById(id);
            doctorService.delete(id);
            return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") int id, @RequestBody Doctor doctor){
        Doctor doctorFind = doctorService.findById(id);
        try{
            doctor.setDoctor_id(doctorFind.getDoctor_id());
            return new ResponseEntity<Doctor>(doctorService.update(doctor), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findPatientById(@PathVariable("id") int id){
        try{
            Doctor doctor = doctorService.findById(id);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

}
