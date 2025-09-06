package com.zaid.patel.REST_APIs.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentDto {
    @NotBlank(message = "Name is Required")
    @Size(min = 3, max = 50, message = "Min 3 and Max 50")
    private String name;
    @Email
    @NotBlank(message = "Email is Required")
    private String email;
    public AddStudentDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
