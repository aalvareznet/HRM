package com.hrm.HRM.repository;

import com.hrm.HRM.model.VacationRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRequestRepo extends JpaRepository<VacationRequestModel, Long> {
}
