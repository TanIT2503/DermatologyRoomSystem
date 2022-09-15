package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String key_name, Model model){
        List<Patient> patients = patientService.findAllByName(key_name);
        model.addAttribute("patients", patients);
        model.addAttribute("key__name", key_name);
        return "patient/list";
    }
}
