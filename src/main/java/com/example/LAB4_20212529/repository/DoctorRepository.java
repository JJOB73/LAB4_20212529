package com.example.LAB4_20212529.repository;

import com.example.LAB4_20212529.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


    @Query(value="SELECT * FROM hospital_db.doctor d where d.hospital_id=?1", nativeQuery=true)
    List<Doctor> ListaDoctores();



}
