package com.zaid.patel.REST_APIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data  // The Data Annotation creates the getters, setters, constructors etc
public class StudentDTO {
    private int id;
    private String name;
    private String email;

    public StudentDTO(int id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
