package com.hrm.HRM.repository;

import com.hrm.HRM.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<DepartmentModel, Long> {
}
