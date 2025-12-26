package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_availability")
public class EmployeeAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @Column(name = "available_date", nullable = false)
    private LocalDate availableDate;
    
    @Column(nullable = false)
    private Boolean available = true;
    
    public EmployeeAvailability() {}
    
    public EmployeeAvailability(Employee employee, LocalDate availableDate, Boolean available) {
        this.employee = employee;
        this.availableDate = availableDate;
        this.available = available != null ? available : true;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    
    public LocalDate getAvailableDate() { return availableDate; }
    public void setAvailableDate(LocalDate availableDate) { this.availableDate = availableDate; }
    
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available != null ? available : true; }
}