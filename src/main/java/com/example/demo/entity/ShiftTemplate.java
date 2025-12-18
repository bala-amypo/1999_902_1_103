package com.example.demo.entity;
import java.Time.*;
import jakarta.persistence.*;
public class ShiftTemplate{
    private Long id;
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;

    public int getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getTemplateName(){
        return template
    }
}