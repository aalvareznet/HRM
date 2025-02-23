package com.hrm.HRM.repository;

import com.hrm.HRM.model.AttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepo extends JpaRepository<AttendanceModel, Long> {
}
