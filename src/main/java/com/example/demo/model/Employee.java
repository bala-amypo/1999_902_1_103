// package com.example.demo.model;
// import java.time.LocalDateTime;
// import jakarta.persistence.*;

// @Entity
// public class Employee{
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private String fullname;
//     private String email;
//     private String role;
//     private String skills;
//     private int maxWeeklyHours;
//     private LocalDateTime createdAt;

//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public String getFullName(){
//         return fullname;
//     }
//     public void setFullName(String fullname){
//         this.fullname=fullname;
//     }
//     public String getEmail(){
//         return email;
//     }
//     public void setEmail(String email){
//         this.email=email;
//     }
//     public String getRole(){
//         return role;
//     }
//     public void setRole(String role ){
//         this.role=role;
//     }
//     public String getSkills(){
//         return skills;
//     }
//     public void setSkills(String skills){
//         this.skills=skills;
//     }
//     public int getMaxWeeklyHours(){
//         return maxWeeklyHours;
//     }
//     public void setMaxWeeklyHours(int maxWeeklyHours){
//         this.maxWeeklyHours=maxWeeklyHours;
//     }
//     public LocalDateTime getCreatedAt(){
//         return createdAt;
//     }
//     public void setCreatedAt(LocalDateTime createdAt){
//         this.createdAt=createdAt;
//     }
//     public Employee(Long id,String fullname,String email,String role,String skills,int maxWeeklyHours,LocalDateTime createdAt){
//         this.id=id;
//         this.fullname=fullname;
//         this.email=email;
//         this.role=role;
//         this.skills=skills;
//         this.maxWeeklyHours=maxWeeklyHours;
//         this.createdAt=createdAt;
//     }
//     public Employee(){
//     }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "employees",
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String role = "STAFF";
    private String skills;
    private Integer maxWeeklyHours;
    private LocalDateTime createdAt;

    public Employee() {}

    public Employee(String fullName, String email, Integer maxWeeklyHours) {
        this.fullName = fullName;
        this.email = email;
        this.maxWeeklyHours = maxWeeklyHours;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getSkills() {
        return skills;
    }

    public Integer getMaxWeeklyHours() {
        return maxWeeklyHours;
    }

    /** REQUIRED by EmployeeServiceImpl */
    public Integer getMaxHoursPerWeek() {
        return this.maxWeeklyHours;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setMaxWeeklyHours(Integer maxWeeklyHours) {
        this.maxWeeklyHours = maxWeeklyHours;
    }
}
