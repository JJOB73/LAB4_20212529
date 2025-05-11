package com.example.LAB4_20212529.repository;

import com.example.LAB4_20212529.entity.Hospital;
import com.example.LAB4_20212529.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    @Query("SELECT p FROM Paciente p WHERE p.hospital.id = ?1")
    List<Paciente> findPacientesByHospitalId(Integer hospitalId);
}