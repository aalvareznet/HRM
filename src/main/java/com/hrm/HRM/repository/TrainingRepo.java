package com.hrm.HRM.repository;

import com.hrm.HRM.model.TrainingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepo extends JpaRepository<TrainingModel, Long> {
}
