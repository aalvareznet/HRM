package com.hrm.HRM.repository;

import com.hrm.HRM.model.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<ReportModel, Long> {
}
