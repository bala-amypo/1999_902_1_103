package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Employee{
    private Long id;
    private String fullname;
    private String email;
    private String role;
    private String skills;
    private int maxWeeklyHours;
    private LocalDateTime createdAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getFullName(){
        return fullname;
    }
    public void setFullName(String fullname){
        this.fullname=fullname;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role ){
        this.role=role;
    }
    public String getSkills(){
        return skills;
    }
    public void setSkills(String skills){
        this.skills=skills;
    }
    public int getMaxWeeklyHours(){
        return maxWeeklyHours;
    }
    public void setMaxWeeklyHours(int maxWeeklyHours){
        this.maxWeeklyHours=maxWeeklyHours;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
    public Employee(Long id,String fullname,String email,String role,String skills,int maxWeeklyHours,LocalDateTime createdAt){
        this.id=id;
        this.fullname=fullname;
        this.email=email;
        this.role=role;
        this.skills=skills;
        this.maxWeeklyHours=maxWeeklyHours;
        this.createdAt=createdAt;
    }
    public Employee(){
    }
}
