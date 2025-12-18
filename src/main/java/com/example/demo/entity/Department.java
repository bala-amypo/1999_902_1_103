package com.example.demo.entity;
import java.time.LocalDateTime;
public class Department{
    private Long id;
    private String name;
    private String description;
    private String requiredSkills;
    private LocalDateTime createdAt;

    public int getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public Department(){
        
    }
}