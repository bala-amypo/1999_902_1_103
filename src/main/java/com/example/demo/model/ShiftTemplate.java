package com.example.demo.model;
import java.time.*;
import jakarta.persistence.*;

@Entity
public class ShiftTemplate{
    //@ManyToOneDepartment
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;
    private String department;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTemplateName(){
        return templateName;
    }
    public void setTemplateName(String templateName){
        this.templateName=templateName;
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
    public String getRequiredSkills(){
        return requiredSkills;
    }
    public void setRequiredSkills(String requiredSkills){
        this.requiredSkills=requiredSkills;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public ShiftTemplate(Long id,String templateName,LocalTime startTime,LocalTime endTime,String requiredSkills,String department){
        this.id=id;
        this.templateName=templateName;
        this.startTime=startTime;
        this.endTime=endTime;
        this.requiredSkills=requiredSkills;
        this.department=department;
    }
    public ShiftTemplate(){

    }
}