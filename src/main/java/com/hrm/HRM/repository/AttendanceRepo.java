package com.hrm.HRM.repository;

import com.hrm.HRM.model.AttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<AttendanceModel, Long> {
}
