package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.dto.PatientDto;
import com.cdio.dermatologroomsystem.entity.Patient;
import com.cdio.dermatologroomsystem.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/create")
    public String showForm(Model model){
        PatientDto patientDto = new PatientDto();
        model.addAttribute("patientDto", patientDto);
        return "patient/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated PatientDto patientDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("patientDto", patientDto);
            return "/patient/create";
        }else {
            Patient patient = new Patient();
            BeanUtils.copyProperties(patientDto,patient);
            patientService.add(patient);
            return "redirect:/patient/list";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id){
        patientService.delete(id);
        return "redirect:/patient/list";
    }
}
