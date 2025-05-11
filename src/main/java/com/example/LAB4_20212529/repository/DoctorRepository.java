package com.example.LAB4_20212529.repository;

import com.example.LAB4_20212529.entity.Doctor;
import com.example.LAB4_20212529.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    
    // Pregunta 3: Buscar doctores por hospital
    @Query("SELECT d FROM Doctor d WHERE d.hospital.id = ?1")
    List<Doctor> findDoctoresByHospitalId(Integer hospitalId);
    
    // Pregunta 4: Buscar pacientes con citas futuras (no atendidos aún)
    @Query(value = "SELECT * FROM doctor d " +
           "INNER JOIN paciente p ON d.id = p.doctor_id " +
           "WHERE d.id = ?1 " + 
           "AND DATE(p.fecha_cita) > CURRENT_DATE " +
           "ORDER BY p.fecha_cita ASC", nativeQuery = true)
    List<Paciente> findPacientesNoAtendidosByDoctorId(Integer doctorId);
}
