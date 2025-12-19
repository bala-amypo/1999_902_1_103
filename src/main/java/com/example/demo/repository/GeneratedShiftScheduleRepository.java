package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GeneratedShiftSchedule;

@Repository
public interface GeneratedShiftScheduleRepository extends JpaRepository<GeneratedShiftSchedule,Integer>{
    
}