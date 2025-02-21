package com.hrm.HRM.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "job_position")
public class JobPositionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    private Double minSalary;

    private Double maxSalary;

    @OneToMany(mappedBy = "jobPosition", cascade = CascadeType.ALL)
    private List<EmployeeModel> employees;
}
