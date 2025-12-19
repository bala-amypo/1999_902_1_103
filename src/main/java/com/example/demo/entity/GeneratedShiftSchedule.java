package com.example.demo.entity;
import java.time.*;
import jakarta.persistence.*;

@Entity
public class GeneratedShiftSchedule{
    private Long id;
    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Long getId(){
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
    public LocalTime getStartTime(){
        return startTime;
    }
    public void setStartTime(LocalTime startTime){
        this.startTime=startTime;
    }
    public LocalTime getEndTime(){
        return endTime;
    }
    public void setEndTime(LocalTime endTime){
        this.endTime=endTime;
    }
    public GeneratedShiftSchedule(Long id,LocalDate shiftDate,LocalTime startTime,LocalDate endTime){
        this.id=id;
        this.shiftDate=shiftDate;
        this.startTime=startTime;
        this.endTime=endTime;
    }
    public GeneratedShiftSchedule(){

    }
}