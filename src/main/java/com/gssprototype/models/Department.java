package com.gssprototype.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;
    @Column(name="department_name")
    private String departmentName;
    @Column(name="department_description")
    private String description;
    @OneToMany(mappedBy="departments")
    @Column(name="employees")
    private List<Employee> employees;


}
