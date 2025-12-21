package com.example.demo.service;

import java.time.*;

public interface EmployeeService{
    Employee createEmployee(Employee employee);
    Employee getEmployee(Long id);

}