package com.example.LAB4_20212529.controller;

import com.example.LAB4_20212529.entity.Doctor;
import com.example.LAB4_20212529.repository.DoctorRepository;
import com.example.LAB4_20212529.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ListController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @GetMapping("/hospitales")
    public String listHospitales(Model model) {
        model.addAttribute("hospitalList", hospitalRepository.findAll());
        return "Listas/listaHospitales";
    }


    @Autowired DoctorRepository doctorRepository;
    @GetMapping("/listaDoctoresPorHospital/{id}")
    public String listDoDoctoresPorHospital(@PathVariable("id") int id, Model model) {
        model.addAttribute("doctorlList", doctorRepository.ListaDoctores());
        return "Lista/listaDoctores";
    }
}
