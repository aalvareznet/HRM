package com.hrm.HRM.repository;

import com.hrm.HRM.model.VacationRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRequestRepo extends JpaRepository<VacationRequestModel, Long> {
}
