// package com.example.demo.model;

// import java.time.*;
// import jakarta.persistence.*;

// @Entity
// public class GeneratedShiftSchedule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private LocalDate shiftDate;
//     private LocalTime startTime;
//     private LocalTime endTime;
//     @ManyToOne
//     @JoinColumn(name = "department_id", nullable = false)
//     private Department department;

//     @ManyToOne
//     @JoinColumn(name = "employee_id", nullable = false)
//     private Employee employee;

//     @ManyToOne
//     @JoinColumn(name = "shift_template_id", nullable = false)
//     private ShiftTemplate shiftTemplate;

//     public Long getId() {
//         return id;
//     }
//     public void setId(Long id) {
//         this.id = id;
//     }
//     public LocalDate getShiftDate() {
//         return shiftDate;
//     }
//     public void setShiftDate(LocalDate shiftDate) {
//         this.shiftDate = shiftDate;
//     }
//     public LocalTime getStartTime() {
//         return startTime;
//     }
//     public void setStartTime(LocalTime startTime) {
//         this.startTime = startTime;
//     }
//     public LocalTime getEndTime() {
//         return endTime;
//     }
//     public void setEndTime(LocalTime endTime) {
//         this.endTime = endTime;
//     }
//     public Department getDepartment() {
//         return department;
//     }
//     public void setDepartment(Department department) {
//         this.department = department;
//     }
//     public Employee getEmployee() {
//         return employee;
//     }
//     public void setEmployee(Employee employee) {
//         this.employee = employee;
//     }
//     public ShiftTemplate getShiftTemplate() {
//         return shiftTemplate;
//     }
//     public void setShiftTemplate(ShiftTemplate shiftTemplate) {
//         this.shiftTemplate = shiftTemplate;
//     }

//     public GeneratedShiftSchedule() {
//     }

//     public GeneratedShiftSchedule(Long id,LocalDate shiftDate,LocalTime startTime,LocalTime endTime,Department department,Employee employee,ShiftTemplate shiftTemplate) {
//         this.id = id;
//         this.shiftDate = shiftDate;
//         this.startTime = startTime;
//         this.endTime = endTime;
//         this.department = department;
//         this.employee = employee;
//         this.shiftTemplate = shiftTemplate;
//     }
// }

package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "generated_shift_schedules")
public class GeneratedShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "shift_template_id")
    private ShiftTemplate shiftTemplate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /** REQUIRED by JPA */
    public GeneratedShiftSchedule() {}

    /** REQUIRED by ScheduleServiceImpl */
    public GeneratedShiftSchedule(
            Employee employee,
            ShiftTemplate shiftTemplate,
            LocalDate shiftDate,
            LocalTime startTime,
            LocalTime endTime
    ) {
        this.employee = employee;
        this.shiftTemplate = shiftTemplate;
        this.department = shiftTemplate.getDepartment();
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getShiftDate() {
        return shiftDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public ShiftTemplate getShiftTemplate() {
        return shiftTemplate;
    }

    public Department getDepartment() {
        return department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setShiftDate(LocalDate shiftDate) {
        this.shiftDate = shiftDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setShiftTemplate(ShiftTemplate shiftTemplate) {
        this.shiftTemplate = shiftTemplate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
