package com.example.LAB4_20212529.repository;

import com.example.LAB4_20212529.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}