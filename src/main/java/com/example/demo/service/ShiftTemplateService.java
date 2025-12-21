package com.example.demo.service;
public interface ShiftTemplateService{
    ShiftTemplate create(ShiftTemplate template);
    List<ShiftTemplate> getByDepartment(Long departmentId);
}