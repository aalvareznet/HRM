package com.hrm.HRM.repository;

import com.hrm.HRM.model.PerformanceReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceReviewRepo extends JpaRepository<PerformanceReviewModel, Long> {
}
