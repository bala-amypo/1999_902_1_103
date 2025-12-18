package com.example.demo.entity;
import java.Time.*;
import jakarta.persistence.*;

@Entity
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
    public void setAvailableData(LocalDate availableData){
        this.availableData=availableData;
    }
    public Boolean getAvailable(){
        return available;
    }
    public void setAvailable(Boolean available){
        this.available=available;
    }
    public EmployeeAvailability(Long id,Local availableData,Boolean available){
        this.id=id;
        this.availableData=availableData;
        this.available=available;
    }
    public EmployeeAvailability(){

    }
}