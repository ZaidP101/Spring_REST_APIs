package com.zaid.patel.REST_APIs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


//ORM frameworks map:
//Classes ⇄ Database tables
//Fields ⇄ Columns
//Object instances ⇄ Table rows

@Entity //will create a table in DB
public class Students {
    @Id //Marks a field as the primary key of the entity.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Typically maps to an auto-increment column in databases id 1 then 2 then 3
    private int id;
    private String name;
    private  String email;


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
