package com.hrm.HRM.repository;

import com.hrm.HRM.model.LeaveRequestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequestModel, Long> {
}
