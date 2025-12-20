package com.example.demo.model;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
public class Department{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String requiredSkills;
    private LocalDateTime createdAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description ){
        this.description=description;
    }
    public String getRequiredSkills(){
        return requiredSkills;
    }
    public void setRequiredSkills(String requiredSkills){
        this.requiredSkills=requiredSkills;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
    public Department(Long id,String name,String description,String requiredSkills,LocalDateTime createdAt){
        this.id=id;
        this.name=name;
        this.description=description;
        this.requiredSkills=requiredSkills;
        this.createdAt=createdAt;
    }
    public Department(){

    }
}