package com.hrm.HRM.repository;

import com.hrm.HRM.model.PayrollModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepo extends JpaRepository<PayrollModel, Long> {
}
