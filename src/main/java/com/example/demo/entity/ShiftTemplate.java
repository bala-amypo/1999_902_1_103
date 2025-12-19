package com.example.demo.entity;
import java.time.*;
import jakarta.persistence.*;

@Entity
public class ShiftTemplate{
    @ManyToOne
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;

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
    public ShiftTemplate(Long id,String templateName,LocalTime startTime,LocalTime endTime,String requiredSkills){
        this.id=id;
        this.templateName=templateName;
        this.startTime=startTime;
        this.endTime=endTime;
        this.requiredSkills=requiredSkills;
    }
    public ShiftTemplate(){

    }
}