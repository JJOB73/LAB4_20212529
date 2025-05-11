package com.example.LAB4_20212529.repository;

import com.example.LAB4_20212529.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    
    @Query(value = "SELECT * FROM doctor WHERE hospital_id = ?1", nativeQuery = true)
    List<Doctor> findDoctoresByHospitalId(Integer hospitalId);
    
    @Query(value = "SELECT d.* FROM doctor d " +
           "INNER JOIN paciente p ON d.id = p.doctor_id " +
           "WHERE p.fecha_cita > CURRENT_DATE", nativeQuery = true)
    List<Doctor> findDoctoresWithPendingAppointments();
}
