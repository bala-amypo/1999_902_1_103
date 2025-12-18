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
    public void setName(String Name){
        this.name=name;
    }
    
    public Department(Long id,String name,String description,String requiredSkills,LocalDateTime createdAt){
        this.id=id;
        this.name=name;
        this.description=description;
        this.requiredSkills=requiredSkills;
        this.createdAt=createdAt;
    }
    public Department(){

    }
}