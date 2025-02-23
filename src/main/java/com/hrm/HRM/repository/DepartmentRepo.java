package com.hrm.HRM.repository;

import com.hrm.HRM.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentModel, Long> {
}
