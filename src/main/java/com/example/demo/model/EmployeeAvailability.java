// package com.example.demo.model;
// import java.time.*;
// import jakarta.persistence.*;

// @Entity
// public class EmployeeAvailability{
//     //@ManyToOneEmployee
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     @ManyToOne
//     @JoinColumn(name="employee_id")
//     private Employee employee;
//     private LocalDate availableData;
//     private Boolean available;

//     public Long getId(){
//          return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }
//     public Employee getEmployee(){
//         return employee;
//     }
//     public void setEmployee(Employee employee){
//         this.employee=employee;
//     }
//     public LocalDate getAvailableData(){
//         return availableData;
//     }
//     public void setAvailableData(LocalDate availableData){
//         this.availableData=availableData;
//     }
//     public Boolean getAvailable(){
//         return available;
//     }
//     public void setAvailable(Boolean available){
//         this.available=available;
//     }
//     public EmployeeAvailability(Long id,LocalDate availableData,Boolean available){
//         this.id=id;
//         this.availableData=availableData;
//         this.available=available;
//     }
//     public EmployeeAvailability(){

//     }
// }

package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class EmployeeAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    
    private LocalDate availableDate;
    private Boolean available;

    public EmployeeAvailability() {}

    public EmployeeAvailability(Employee employee, LocalDate availableDate, Boolean available) {
        this.employee = employee;
        this.availableDate = availableDate;
        this.available = available;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    public LocalDate getAvailableDate() { return availableDate; }
    public void setAvailableDate(LocalDate availableDate) { this.availableDate = availableDate; }
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}