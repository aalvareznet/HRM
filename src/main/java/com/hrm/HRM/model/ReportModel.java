package com.hrm.HRM.model;

import com.hrm.HRM.enums.ReportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "report")
public class ReportModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private ReportType type;

    @Temporal(TemporalType.TIMESTAMP)
    private Date generatedAt;

    @Lob
    private String content; // JSON, HTML o texto del reporte

    @ManyToOne
    @JoinColumn(name = "generated_by", nullable = false)
    private EmployeeModel generatedBy;
}
