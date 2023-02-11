package com.gssprototype.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @JoinColumn(name="department_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="department")
    private Department department;
}
