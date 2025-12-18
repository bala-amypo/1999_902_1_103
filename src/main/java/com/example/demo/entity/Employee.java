package com.example.demo.entity;
import java.time.LocalDateTime;
public class Employee{
    private Long id;
    private String fullname;
    private String email;
    private String role;
    private String skills;
    private int maxWeeklyHours;
    private LocalDateTime createdAt;

    public int getId(){
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
    public 
}
