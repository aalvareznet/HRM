package com.hrm.HRM.controller;

import com.hrm.HRM.model.PayrollModel;
import com.hrm.HRM.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/payroll")
public class PayrollController {

    @Autowired
    private PayrollService service;

    @GetMapping("/{id}")
    public ResponseEntity<List<PayrollModel>> getPayrollByEmployeeId(@PathVariable Long id){
        Optional<List<PayrollModel>> payroll = service.getByEmployeeId(id);
        if(payroll.isPresent()){
            List<PayrollModel> returnPayroll = payroll.get();
            return ResponseEntity.ok(returnPayroll);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
