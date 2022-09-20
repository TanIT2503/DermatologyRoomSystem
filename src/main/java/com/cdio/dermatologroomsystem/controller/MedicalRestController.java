package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Medical;
import com.cdio.dermatologroomsystem.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/medical")
public class MedicalRestController {
    @Autowired
    private MedicalService medicalService;

    @GetMapping
    public ResponseEntity<List<Medical>> findAll(){
        List<Medical> medicalList = medicalService.findAll();
        if (medicalList.isEmpty()){
            return new ResponseEntity<List<Medical>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Medical>>(medicalList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medical> findMedicalById(@PathVariable("id") Integer id){
        try {
            Medical medical = medicalService.findById(id);
            return new ResponseEntity<Medical>(medical, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Medical>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<Medical> updateMedical(@PathVariable("id") Integer id, @RequestBody Medical medical){
        Medical medicalFind = medicalService.findById(id);
        try{
            medical.setMedicalId(medicalFind.getMedicalId());
            return new ResponseEntity<Medical>(medicalService.update(medical), HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Medical>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medical> deleteMedical(@PathVariable("id") Integer id){
        try {
            Medical medical = medicalService.findById(id);
            medicalService.delete(id);
            return new ResponseEntity<Medical>(medical, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Medical>(HttpStatus.NOT_FOUND);
        }
    }
}
