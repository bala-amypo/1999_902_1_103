package com.example.demo.entity;
import java.Time.*;
import jakarta persistence.*;
public class GeneratedShiftSchedule{
    private Long id;
    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public int getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public LocalDate getShiftData(){
        return shiftDate;
    }
    public void setShiftData(LocalDate shiftDate){
        this.shiftDate=shiftDate;
    }
    public 
}