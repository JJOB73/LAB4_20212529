package com.example.LAB4_20212529.controller;

import com.example.LAB4_20212529.entity.Doctor;
import com.example.LAB4_20212529.entity.Paciente;
import com.example.LAB4_20212529.repository.DoctorRepository;
import com.example.LAB4_20212529.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("")
    public String listPacientes(Model model) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        model.addAttribute("listaPacientes", pacientes);
        return "patientFlow/listaPacientes";
    }

    @GetMapping("/derivar")
    public String mostrarFormularioDerivacion(Model model) {
        List<Doctor> doctores = doctorRepository.findAll();
        model.addAttribute("listaDoctores", doctores);
        return "patientFlow/derivarPacientes";
    }

    @PostMapping("/derivar")
    public String derivarPacientes(@RequestParam("doctorOrigenId") Integer doctorOrigenId,
                                 @RequestParam("doctorDestinoId") Integer doctorDestinoId) {
        
        if (!doctorOrigenId.equals(doctorDestinoId)) {
            // Usar SQL nativo para actualizar sin usar .save()
            pacienteRepository.transferirPacientes(doctorOrigenId, doctorDestinoId);
        }
        
        return "redirect:/pacientes";
    }
}
