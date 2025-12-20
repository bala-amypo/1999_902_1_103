package com.example.demo.model;
import java.time.*;
import jakarta.persistence.*;

@Entity
public class GeneratedShiftSchedule{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name="department_id")
    @JoinColumn(name="employee_id")
    @JoinColumn(name="shiftTemplate_id")
    private Department department;
    private Employee employee;
    private ShiftTemplate shiftTemplate;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public LocalDate getShiftData(){
        return shiftDate;
    }
    public void setShiftData(LocalDate shiftDate){
        this.shiftDate=shiftDate;
    }
    public LocalTime getStartTime(){
        return startTime;
    }
    public void setStartTime(LocalTime startTime){
        this.startTime=startTime;
    }
    public LocalTime getEndTime(){
        return endTime;
    }
    public void setEndTime(LocalTime endTime){
        this.endTime=endTime;
    }
    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department=department;
    }
    public Employee getEmployee(){
        return employee;
    }
    public void setEmployee(Employee employee){
        this.employee=employee;
    }
    public ShiftTemplate getShiftTemplate(){
        return shiftTemplate;
    }
    public void setShiftTemplate(ShiftTemplate shiftTemplate){
        this.shiftTemplate=shiftTemplate;
    }


    public GeneratedShiftSchedule(Long id,LocalDate shiftDate,LocalTime startTime,LocalTime endTime,Department department,Employee employee,ShiftTemplate shiftTemplate){
        this.id=id;
        this.shiftDate=shiftDate;
        this.startTime=startTime;
        this.endTime=endTime;
        this.department=department;
        this.employee=employee;
        this.shiftTemplate=shiftTemplate;
    }
    public GeneratedShiftSchedule(){

    }
}