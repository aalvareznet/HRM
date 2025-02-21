package com.hrm.HRM.model;

import com.hrm.HRM.enums.EmployeeStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private DepartmentModel department;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private JobPositionModel jobPosition;

    private Date hireDate;

    private Double salary;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<PayrollModel> payrolls;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<VacationRequestModel> vacationRequests;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<PerformanceReviewModel> performanceReviews;
}
