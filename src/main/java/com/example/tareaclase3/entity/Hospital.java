package com.example.tareaclase3.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String direccion;

    private String telefono;

}
