package com.example.LAB4_20212529.repository;

import com.example.LAB4_20212529.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE paciente SET doctor_id = ?2 WHERE doctor_id = ?1", nativeQuery = true)
    void transferirPacientes(Integer doctorOrigenId, Integer doctorDestinoId);
}
