package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            List<ShiftTemplate> shiftTemplates = shiftTemplateRepository.findByDepartment_Id(department.getId());
            
            for (ShiftTemplate shiftTemplate : shiftTemplates) {
                for (EmployeeAvailability availability : availableEmployees) {
                    Employee employee = availability.getEmployee();
                    
                    // Check if employee skills match shift requirements
                    if (employee.getSkills() != null && shiftTemplate.getRequiredSkills() != null) {
                        boolean hasMatchingSkill = false;
                        String[] employeeSkills = employee.getSkills().split(",");
                        String[] requiredSkills = shiftTemplate.getRequiredSkills().split(",");
                        
                        for (String empSkill : employeeSkills) {
                            for (String reqSkill : requiredSkills) {
                                if (empSkill.trim().equals(reqSkill.trim())) {
                                    hasMatchingSkill = true;
                                    break;
                                }
                            }
                            if (hasMatchingSkill) break;
                        }
                        
                        if (hasMatchingSkill) {
                            GeneratedShiftSchedule schedule = new GeneratedShiftSchedule(
                                employee, shiftTemplate, date, 
                                shiftTemplate.getStartTime(), shiftTemplate.getEndTime()
                            );
                            schedules.add(scheduleRepository.save(schedule));
                            break; // One employee per shift
                        }
                    }
                }
            }
        }
        
        return schedules;
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) {
        return scheduleRepository.findByShiftDate(date);
    }
}