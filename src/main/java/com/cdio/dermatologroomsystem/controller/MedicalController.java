package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.entity.Medical;
import com.cdio.dermatologroomsystem.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/medical")
public class MedicalController {
    @Autowired
    private MedicalService medicalService;

    @GetMapping("/list")
    public String showList(@RequestParam(defaultValue = "") String key_name, Model model){
        List<Medical> medicals = medicalService.findAllByName(key_name);
        model.addAttribute("medicals", medicals);
        model.addAttribute("key_name", key_name);
        return null;
    }
}
