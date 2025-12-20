package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.EmployeeAvailability;

@Repository
public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability,Integer>{
    
}