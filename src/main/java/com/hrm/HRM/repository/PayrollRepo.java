package com.hrm.HRM.repository;

import com.hrm.HRM.model.PayrollModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayrollRepo extends JpaRepository<PayrollModel, Long> {
    Optional<List<PayrollModel>> findByEmployeeId(Long employeeId);
}
