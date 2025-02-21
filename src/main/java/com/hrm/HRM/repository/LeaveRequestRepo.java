package com.hrm.HRM.repository;

import com.hrm.HRM.model.LeaveRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequestModel, Long> {
}
