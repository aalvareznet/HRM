package com.hrm.HRM.service;

import com.hrm.HRM.enums.EmployeeStatus;
import com.hrm.HRM.model.EmployeeModel;
import com.hrm.HRM.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService extends BaseService<EmployeeModel, Long>{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    protected EmployeeRepo getRepository() {
        return employeeRepo;
    }

    public List<EmployeeModel> getByStatus(EmployeeStatus employeeStatus){
        return employeeRepo.findByStatus(employeeStatus);
    }

    public void activateEmployee(Long id) {

    }
}
