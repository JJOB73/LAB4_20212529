package com.example.LAB4_20212529.controller;

import com.example.LAB4_20212529.entity.Doctor;
import com.example.LAB4_20212529.entity.Hospital;
import com.example.LAB4_20212529.entity.Paciente;
import com.example.LAB4_20212529.repository.DoctorRepository;
import com.example.LAB4_20212529.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ListController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired 
    private DoctorRepository doctorRepository;

    @GetMapping("/hospitales")
    public String listHospitales(Model model) {
        List<Hospital> hospitales = hospitalRepository.findAll();
        model.addAttribute("listaHospitales", hospitales);
        return "Listas/listaHospitales";
    }

    @GetMapping("/doctores")
    public String listDoctores(Model model) {
        List<Doctor> doctores = doctorRepository.findAll();
        model.addAttribute("listaDoctores", doctores);
        return "Listas/listaDoctores";
    }

    @GetMapping("/hospital/{id}/doctores")
    public String listDoctoresPorHospital(@PathVariable("id") Integer id, Model model) {
        List<Doctor> doctores = doctorRepository.findDoctoresByHospitalId(id);
        model.addAttribute("listaDoctores", doctores);
        model.addAttribute("hospitalId", id);
        return "Listas/listaDoctores";
    }

    @GetMapping("/hospital/{id}/pacientes")
    public String listPacientesPorHospital(@PathVariable("id") Integer id, Model model) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        if (hospital != null) {
            List<Paciente> pacientes = hospitalRepository.findPacientesByHospitalId(id);
            model.addAttribute("listaPacientes", pacientes);
            model.addAttribute("hospital", hospital);
        }
        return "Listas/listaPacientesHospital";
    }
}
