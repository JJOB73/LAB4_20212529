package com.example.tareaclase3.entity;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String especialidad;


    @OneToMany(mappedBy = "hospital")
    private List<Doctor> doctores;
}


