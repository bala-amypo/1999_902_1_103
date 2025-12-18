package com.example.demo.entity;
import java.Time.*;
import jakarta.persistence.*;
public class EmployeeAvailability{
    private Long id;
    private LocalDate availableData;
    private Boolean available;

    public int getId(){
         return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public LocalDate getAvailableData(){
        return availableData;
    }
    public void setAvailableData()
}