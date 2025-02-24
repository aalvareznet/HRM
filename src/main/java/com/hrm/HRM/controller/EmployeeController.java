package com.hrm.HRM.controller;


import com.hrm.HRM.Mapper.EmployeeMapper;
import com.hrm.HRM.dto.EmployeeDto;
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
    @Autowired
    private EmployeeMapper mapper;

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getEmployees(){
        List<EmployeeModel> employeeList = service.findAll();
        List<EmployeeDto> returnList = employeeList.stream()
                .map(mapper::convertToDto)
                .toList();
        return ResponseEntity.ok(returnList);
    }
    @PostMapping("/")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeModel employeeModel){
        EmployeeModel employee = service.create(employeeModel);
        EmployeeDto returnEmployee = mapper.convertToDto(employeeModel);
        return ResponseEntity.ok(returnEmployee);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
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
            employeeToUpdate.setPhoneNumber(employeeModel.getPhoneNumber());
            EmployeeModel updatedEmployee = service.update(employeeToUpdate);
            EmployeeDto returnEmployee = mapper.convertToDto(updatedEmployee);
            return ResponseEntity.ok(returnEmployee);
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
    public ResponseEntity<List<EmployeeDto>> getAllEmployeesByStatus(@PathVariable String status){
        EmployeeStatus employeeStatus = EmployeeStatus.valueOf(status.toUpperCase());
        List<EmployeeModel> employees = service.getByStatus(employeeStatus);
        if (employees.isEmpty()){
            return ResponseEntity.notFound().build();
        } else{
            List<EmployeeDto> returnList = employees.stream()
                                                    .map(mapper::convertToDto)
                                                    .toList();
            return ResponseEntity.ok(returnList);
        }
    }
    @PutMapping("/{id}/activate")
    public ResponseEntity<EmployeeDto> activateEmployee(@PathVariable Long id){
        Optional<EmployeeModel> employeeOption = service.findById(id);
        if (employeeOption.isPresent()){
            EmployeeModel employeeToUpdate = employeeOption.get();
            if (employeeToUpdate.getStatus() != EmployeeStatus.ACTIVE){
                employeeToUpdate.setStatus(EmployeeStatus.ACTIVE);
                EmployeeModel updatedEmployee = service.update(employeeToUpdate);
                EmployeeDto returnEmployee = mapper.convertToDto(updatedEmployee);
                return ResponseEntity.ok().body(returnEmployee);
            }
            return ResponseEntity.ok(mapper.convertToDto(employeeToUpdate));
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<EmployeeDto> deactivateEmployee(@PathVariable Long id){
        Optional<EmployeeModel> employeeOption = service.findById(id);
        if (employeeOption.isPresent()){
            EmployeeModel employeeToUpdate = employeeOption.get();
            if (employeeToUpdate.getStatus() == EmployeeStatus.ACTIVE){
                employeeToUpdate.setStatus(EmployeeStatus.INACTIVE);
                EmployeeModel updatedEmployee = service.update(employeeToUpdate);
                EmployeeDto returnEmployee = mapper.convertToDto(updatedEmployee);
                return ResponseEntity.ok().body(returnEmployee);
            }
            return ResponseEntity.ok(mapper.convertToDto(employeeToUpdate));
        }
        return ResponseEntity.notFound().build();
    }
}
