package com.viethoang.week07.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
//    @JsonBackReference
    @JsonIgnore
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Job> jobs;
}
