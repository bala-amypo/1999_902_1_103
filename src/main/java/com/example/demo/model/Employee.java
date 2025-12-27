package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "full_name", nullable = false)
    private String fullName;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String role = "STAFF";
    
    @Column(nullable = false)
    private String skills;
    
    @Column(name = "max_weekly_hours", nullable = false)
    private Integer maxWeeklyHours;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    public Employee() {}
    
    public Employee(String fullName, String email, String role, String skills, Integer maxWeeklyHours) {
        this.fullName = fullName;
        this.email = email;
        this.role = role != null ? role : "STAFF";
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
    }
    
    public List<String> getSkillsList() {
        return skills != null ? Arrays.asList(skills.split(",")) : Arrays.asList();
    }
    
    public void setSkillsList(List<String> skillsList) {
        this.skills = skillsList != null ? String.join(",", skillsList) : null;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role != null ? role : "STAFF"; }
    
    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }
    
    public Integer getMaxWeeklyHours() { return maxWeeklyHours; }
    public void setMaxWeeklyHours(Integer maxWeeklyHours) { this.maxWeeklyHours = maxWeeklyHours; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}