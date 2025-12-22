package com.example.demo.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.model.ShiftTemplate;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.repository.ShiftTemplateRepository;
import com.example.demo.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ShiftTemplateRepository shiftTemplateRepository;

    @Override
    public GeneratedShiftSchedule generateSchedule(
            LocalDate shiftDate,
            java.time.LocalTime startTime,
            java.time.LocalTime endTime,
            Long departmentId,
            Long employeeId,
            Long shiftTemplateId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        ShiftTemplate shiftTemplate = shiftTemplateRepository.findById(shiftTemplateId)
                .orElseThrow(() -> new ResourceNotFoundException("ShiftTemplate not found"));

        GeneratedShiftSchedule schedule = new GeneratedShiftSchedule();

        schedule.setShiftDate(shiftDate != null ? shiftDate : LocalDate.now());
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);

        // 🔴 THESE ARE MANDATORY
        schedule.setDepartment(department);
        schedule.setEmployee(employee);
        schedule.setShiftTemplate(shiftTemplate);

        return scheduleRepository.save(schedule);
    }

    @Override
    public List<GeneratedShiftSchedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public GeneratedShiftSchedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));
    }
}
