package com.hrm.HRM.controller;

import com.hrm.HRM.model.PayrollModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payroll")
public class PayrollController {

    @GetMapping("/{id}")
    public ResponseEntity<PayrollModel> getPayrollByEmployeeId(@PathVariable Long id){

    }
}
