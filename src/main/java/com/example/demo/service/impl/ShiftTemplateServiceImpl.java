package com.example.demo.service.impl;

import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.model.Department;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.ShiftTemplateService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShiftTemplateServiceImpl implements ShiftTemplateService {
    
    private final ShiftTemplateRepository shiftTemplateRepository;
    private final DepartmentRepository departmentRepository;
    
    public ShiftTemplateServiceImpl(ShiftTemplateRepository shiftTemplateRepository, 
                                   DepartmentRepository departmentRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.departmentRepository = departmentRepository;
    }
    
    @Override
    public ShiftTemplate create(ShiftTemplate template) {
        Department department = departmentRepository.findById(template.getDepartment().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        
        if (template.getEndTime().isBefore(template.getStartTime()) || 
            template.getEndTime().equals(template.getStartTime())) {
            throw new ValidationException("End time must be after start time");
        }
        
        if (shiftTemplateRepository.findByTemplateNameAndDepartment_Id(
                template.getTemplateName(), department.getId()).isPresent()) {
            throw new DuplicateResourceException("Template name must be unique within department");
        }
        
        template.setDepartment(department);
        return shiftTemplateRepository.save(template);
    }
    
    @Override
    public List<ShiftTemplate> getByDepartment(Long departmentId) {
        return shiftTemplateRepository.findByDepartment_Id(departmentId);
    }
}