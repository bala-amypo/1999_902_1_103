package com.example.demo.service;

import java.util.*;

public interface DepartmentService{
    Department create(Department department);
    Department get(Long id);
    void delete(Long id);
    List<Department> getAll();
}