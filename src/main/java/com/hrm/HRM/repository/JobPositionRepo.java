package com.hrm.HRM.repository;

import com.hrm.HRM.model.JobPositionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPositionRepo extends JpaRepository<JobPositionModel, Long> {
}
