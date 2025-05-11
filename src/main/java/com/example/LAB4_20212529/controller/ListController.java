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

    // Pregunta 3: Lista de hospitales
    @GetMapping("/hospitales")
    public String listHospitales(Model model) {
        List<Hospital> hospitales = hospitalRepository.findAll();
        model.addAttribute("listaHospitales", hospitales);
        return "Listas/listaHospitales";
    }

    // Pregunta 3: Lista de doctores por hospital
    @GetMapping("/hospital/{id}/doctores")
    public String listDoctoresPorHospital(@PathVariable("id") Integer id, Model model) {
        Hospital hospital = hospitalRepository.findById(id).orElse(null);
        if (hospital != null) {
            List<Doctor> doctores = doctorRepository.findDoctoresByHospitalId(id);
            model.addAttribute("listaDoctores", doctores);
            model.addAttribute("hospital", hospital);
        }
        return "Listas/doctoresPorHospital";
    }

    // Pregunta 3: Lista de pacientes por hospital
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

    // Pregunta 4: Lista general de doctores
    @GetMapping("/doctores")
    public String listDoctores(Model model) {
        List<Doctor> doctores = doctorRepository.findAll();
        model.addAttribute("listaDoctores", doctores);
        return "doctorList/listaDoctores";
    }

    // Pregunta 4: Próximas citas de un doctor
    @GetMapping("/doctor/{id}/proximas-citas")
    public String listProximasCitas(@PathVariable("id") Integer id, Model model) {
        Doctor doctor = doctorRepository.findById(id).orElse(null);
        if (doctor != null) {
            List<Paciente> pacientes = doctorRepository.findPacientesNoAtendidosByDoctorId(id);
            model.addAttribute("listaPacientes", pacientes);
            model.addAttribute("doctor", doctor);
            return "doctorList/proximasCitasDoctor";
        }
        return "redirect:/doctores";
    }
}
