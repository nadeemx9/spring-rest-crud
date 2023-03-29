package com.restcrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    private Integer rollno;
    @NotEmpty(message = "Name should not be null!")
    private String name;
    @NotEmpty(message = "City should not be null!")
    private String city;

}
