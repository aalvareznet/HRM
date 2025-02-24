package com.hrm.HRM.Mapper;

import com.hrm.HRM.dto.EmployeeDto;
import com.hrm.HRM.model.EmployeeModel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto convertToDto(EmployeeModel employeeModel){
        return EmployeeDto.builder()
                .firstName(employeeModel.getFirstName())
                .lastName(employeeModel.getLastName())
                .email(employeeModel.getEmail())
                .phoneNumber(employeeModel.getPhoneNumber())
                .jobPosition(employeeModel.getJobPosition().getTitle())
                .department(employeeModel.getDepartment().getName())
                .salary(employeeModel.getSalary())
                .build();
    }
}
