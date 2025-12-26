package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    
    private final ShiftTemplateRepository shiftTemplateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;
    private final GeneratedShiftScheduleRepository scheduleRepository;
    private final DepartmentRepository departmentRepository;
    
    public ScheduleServiceImpl(ShiftTemplateRepository shiftTemplateRepository,
                              AvailabilityRepository availabilityRepository,
                              EmployeeRepository employeeRepository,
                              GeneratedShiftScheduleRepository scheduleRepository,
                              DepartmentRepository departmentRepository) {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
        this.scheduleRepository = scheduleRepository;
        this.departmentRepository = departmentRepository;
    }
    
    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) {
        List<GeneratedShiftSchedule> schedules = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        List<EmployeeAvailability> availableEmployees = availabilityRepository.findByAvailableDateAndAvailable(date, true);
        
        for (Department department : departments) {
            List<ShiftTemplate> templates = shiftTemplateRepository.findByDepartment_Id(department.getId());
            
            for (ShiftTemplate template : templates) {
                Employee assignedEmployee = findQualifiedEmployee(template, availableEmployees);
                
                if (assignedEmployee != null) {
                    GeneratedShiftSchedule schedule = new GeneratedShiftSchedule(
                        date, template.getStartTime(), template.getEndTime(),
                        template, department, assignedEmployee
                    );
                    schedules.add(scheduleRepository.save(schedule));
                }
            }
        }
        
        return schedules;
    }
    
    private Employee findQualifiedEmployee(ShiftTemplate template, List<EmployeeAvailability> availableEmployees) {
        List<String> requiredSkills = template.getRequiredSkills() != null ? 
            Arrays.asList(template.getRequiredSkills().split(",")) : new ArrayList<>();
        
        for (EmployeeAvailability availability : availableEmployees) {
            Employee employee = availability.getEmployee();
            List<String> employeeSkills = employee.getSkillsList();
            
            boolean hasAllSkills = true;
            for (String skill : requiredSkills) {
                if (!employeeSkills.contains(skill.trim())) {
                    hasAllSkills = false;
                    break;
                }
            }
            
            if (hasAllSkills) {
                return employee;
            }
        }
        
        return null;
    }
    
    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}