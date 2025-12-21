package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GeneratedShiftSchedule;

@Repository
public interface ScheduleRepository extends JpaRepository<GeneratedShiftSchedule,Integer>{
    
}