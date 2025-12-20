package com.example.demo.service;
public interface AvailabilityService{
    EmployeeAvailability create(EmployeeAvailability availability);
    EmployeeAvailability update(Long id,EmployeeAvailability availability);
    void delete(Long id)
}