package com.hrm.HRM.controller;


import com.hrm.HRM.enums.EmployeeStatus;
import com.hrm.HRM.model.EmployeeModel;
import com.hrm.HRM.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeModel>> getEmployees(){
        List<EmployeeModel> employeeList = service.findAll();
        return ResponseEntity.ok(employeeList);
    }
    @PostMapping("/")
    public ResponseEntity<EmployeeModel> createEmployee(@RequestBody EmployeeModel employeeModel){
        EmployeeModel employee = service.create(employeeModel);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id,
                                                        @RequestBody EmployeeModel employeeModel){
        Optional<EmployeeModel> employeeOptional = service.findById(id);
        if(employeeOptional.isPresent()){
            EmployeeModel employeeToUpdate = employeeOptional.get();
            employeeToUpdate.setDepartment(employeeModel.getDepartment());
            employeeToUpdate.setEmail(employeeModel.getEmail());
            employeeToUpdate.setFirstName(employeeModel.getFirstName());
            employeeToUpdate.setPayrolls(employeeToUpdate.getPayrolls()); //this does not change
            employeeToUpdate.setSalary(employeeModel.getSalary());
            employeeToUpdate.setHireDate(employeeToUpdate.getHireDate()); //this does not change;
            employeeToUpdate.setDepartment(employeeModel.getDepartment());
            employeeToUpdate.setJobPosition(employeeModel.getJobPosition());
            employeeToUpdate.setStatus(employeeModel.getStatus());
            EmployeeModel updatedEmployee = service.update(employeeToUpdate);
            return ResponseEntity.ok(updatedEmployee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        Optional<EmployeeModel> employee = service.findById(id);
        if (employee.isPresent()){
            service.delete(id);
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{status}")
    public ResponseEntity<List<EmployeeModel>> getAllEmployeesByStatus(@PathVariable EmployeeStatus employeeStatus){
        List<EmployeeModel> employees = service.getByStatus(employeeStatus);
        if (employees.isEmpty()){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(employees);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> activateEmployee(@PathVariable Long id){
        Optional<EmployeeModel> employeeOption = service.findById(id);
        if (employeeOption.isPresent()){
            EmployeeModel employeeToUpdate = employeeOption.get();
            if (employeeToUpdate.getStatus() != EmployeeStatus.ACTIVE){
                employeeToUpdate.setStatus(EmployeeStatus.ACTIVE);
                EmployeeModel updatedEmployee = service.update(employeeToUpdate);
                return ResponseEntity.ok().body(updatedEmployee);
            }
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> deactivateEmployee(@PathVariable Long id){
        Optional<EmployeeModel> employeeOption = service.findById(id);
        if (employeeOption.isPresent()){
            EmployeeModel employeeToUpdate = employeeOption.get();
            if (employeeToUpdate.getStatus() == EmployeeStatus.ACTIVE){
                employeeToUpdate.setStatus(EmployeeStatus.INACTIVE);
                EmployeeModel updatedEmployee = service.update(employeeToUpdate);
                return ResponseEntity.ok().body(updatedEmployee);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
