package com.example.tareaclase3.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private int edad;
    private String genero;
    private String diagnostico;
    private LocalDate fecha_cita;
    private int numero_habitacion;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
