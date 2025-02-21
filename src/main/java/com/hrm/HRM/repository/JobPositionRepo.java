package com.hrm.HRM.repository;

import com.hrm.HRM.model.JobPositionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionRepo extends JpaRepository<JobPositionModel, Long> {
}
