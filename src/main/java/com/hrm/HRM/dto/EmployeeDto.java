package com.hrm.HRM.dto;
import lombok.Builder;
@Builder
public record EmployeeDto(String firstName,
                          String lastName,
                          String email,
                          String phoneNumber,
                          String department,
                          String jobPosition,
                          Double salary) {
}
