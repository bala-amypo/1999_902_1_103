// package com.example.demo.model;
// import java.time.*;
// import jakarta.persistence.*;

// @Entity
// public class ShiftTemplate{
//     //@ManyToOneDepartment
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique=true)
//     private String templateName;
//     private LocalTime startTime;
//     private LocalTime endTime;
//     private String requiredSkills;
//     @ManyToOne
//     @JoinColumn(name="department_id")
//     private Department department;
    

//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public String getTemplateName(){
//         return templateName;
//     }
//     public void setTemplateName(String templateName){
//         this.templateName=templateName;
//     }
//     public LocalTime getStartTime(){
//         return startTime;
//     }
//     public void setStartTime(LocalTime startTime){
//         this.startTime=startTime;
//     }
//     public LocalTime getEndTime(){
//         return endTime;
//     }
//     public void setEndTime(LocalTime endTime){
//         this.endTime=endTime;
//     }
//     public String getRequiredSkills(){
//         return requiredSkills;
//     }
//     public void setRequiredSkills(String requiredSkills){
//         this.requiredSkills=requiredSkills;
//     }
//     public Department getDepartment(){
//         return department;
//     }
//     public void setDepartment(Department department){
//         this.department=department;
//     }
//     public ShiftTemplate(Long id,String templateName,LocalTime startTime,LocalTime endTime,String requiredSkills,Department department){
//         this.id=id;
//         this.templateName=templateName;
//         this.startTime=startTime;
//         this.endTime=endTime;
//         this.requiredSkills=requiredSkills;
//         this.department=department;
//     }
//     public ShiftTemplate(){

//     }
// }

package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class ShiftTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;
    
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public ShiftTemplate() {}

    public ShiftTemplate(String templateName, LocalTime startTime, LocalTime endTime, String requiredSkills, Department department) {
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
        this.department = department;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
}