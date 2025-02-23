package com.hrm.HRM.repository;

import com.hrm.HRM.enums.EmployeeStatus;
import com.hrm.HRM.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeModel, Long> {
    List<EmployeeModel> findByStatus(EmployeeStatus employeeStatus);
}
