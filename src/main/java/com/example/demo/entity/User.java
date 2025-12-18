package com.example.demo.entity;
import java.time.LocalDateTime;
public class User{
    private Long id;
    private String fullName;
    private String email;
    private String role;
    private String skills;
    private Integer maxWeeklyHours;
    private LocalDateTime createdAt;

    public int getId(){
        return id;
    }
    public void setId(Long id){
        
    }
}