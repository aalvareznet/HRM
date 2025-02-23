package com.hrm.HRM.controller;


import com.hrm.HRM.enums.EmployeeStatus;
import com.hrm.HRM.model.EmployeeModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @GetMapping("/")
    public ResponseEntity<List<EmployeeModel>> getEmployees(){

    }
    @PostMapping("/")
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel){

    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id,
                                                        @RequestBody EmployeeModel employeeModel){

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){

    }
    @GetMapping("/{status}")
    public ResponseEntity<List<EmployeeModel>> getAllEmployeesByStatus(@PathVariable EmployeeStatus employeeStatus){

    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> activateEmployee(@PathVariable Long id){

    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> deactivateEmployee(@PathVariable Long id){

    }
}
