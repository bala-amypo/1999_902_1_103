package com.example.demo.service;
import com.example.demo.model.
public interface AvailabilityService{
     EmployeeAvailability create(EmployeeAvailability availability);
     EmployeeAvailability update(Long id,EmployeeAvailability availability);
     void delete(Long id)
}