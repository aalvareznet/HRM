package com.hrm.HRM.service;

import com.hrm.HRM.model.PayrollModel;
import com.hrm.HRM.repository.PayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class PayrollService extends BaseService<PayrollModel, Long>{
    @Autowired
    private PayrollRepo payrollRepo;

    @Override
    protected PayrollRepo getRepository() {
        return payrollRepo;
    }
}
