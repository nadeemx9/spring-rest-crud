package com.restcrud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    private Integer rollno;
    private String name;
    private String city;

}
