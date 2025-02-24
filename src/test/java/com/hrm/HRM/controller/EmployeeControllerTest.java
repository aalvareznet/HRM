package com.hrm.HRM.controller;

import com.hrm.HRM.Mapper.EmployeeMapper;
import com.hrm.HRM.dto.EmployeeDto;
import com.hrm.HRM.enums.EmployeeStatus;
import com.hrm.HRM.model.EmployeeModel;
import com.hrm.HRM.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeController employeeController;

    private EmployeeModel employeeModel;
    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        employeeModel = new EmployeeModel();
        employeeModel.setId(1L);
        employeeModel.setFirstName("John");
        employeeModel.setLastName("Doe");

        employeeDto = EmployeeDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john@hrm.com")
                .build();
    }
    @Test
    void getEmployees_ShouldReturnListOfEmployees() {
        // Arrange
        List<EmployeeModel> employeeList = Arrays.asList(employeeModel);
        when(employeeService.findAll()).thenReturn(employeeList);
        when(employeeMapper.convertToDto(any(EmployeeModel.class))).thenReturn(employeeDto);

        // Act
        ResponseEntity<List<EmployeeDto>> response = employeeController.getEmployees();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
        verify(employeeService, times(1)).findAll();
    }
    @Test
    void createEmployee_ShouldReturnCreatedEmployee() {
        // Arrange
        when(employeeService.create(any(EmployeeModel.class))).thenReturn(employeeModel);
        when(employeeMapper.convertToDto(any(EmployeeModel.class))).thenReturn(employeeDto);

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.createEmployee(employeeModel);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
        verify(employeeService, times(1)).create(any(EmployeeModel.class));
    }
    @Test
    void updateEmployee_WhenExists_ShouldReturnUpdatedEmployee() {
        // Arrange
        when(employeeService.findById(1L)).thenReturn(Optional.of(employeeModel));
        when(employeeService.update(any(EmployeeModel.class))).thenReturn(employeeModel);
        when(employeeMapper.convertToDto(any(EmployeeModel.class))).thenReturn(employeeDto);

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.updateEmployee(1L, employeeModel);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employeeDto, response.getBody());
        verify(employeeService, times(1)).update(any(EmployeeModel.class));
    }

    @Test
    void updateEmployee_WhenNotExists_ShouldReturnNotFound() {
        // Arrange
        when(employeeService.findById(99L)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.updateEmployee(99L, employeeModel);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
    @Test
    void deleteEmployee_ShouldReturnNoContent() {
        // Arrange
        when(employeeService.findById(1L)).thenReturn(Optional.of(employeeModel)); // <-- ¡Falta este mock!

        // Act
        ResponseEntity<Void> response = employeeController.deleteEmployee(1L);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(employeeService, times(1)).findById(1L);
        verify(employeeService, times(1)).delete(1L); // Ahora sí se ejecutará
    }
    @Test
    void activateEmployee_WhenInactive_ShouldActivate() {
        // Arrange
        employeeModel.setStatus(EmployeeStatus.INACTIVE);
        when(employeeService.findById(1L)).thenReturn(Optional.of(employeeModel));
        when(employeeService.update(any(EmployeeModel.class))).thenReturn(employeeModel);
        when(employeeMapper.convertToDto(any(EmployeeModel.class))).thenReturn(employeeDto);

        // Act
        ResponseEntity<EmployeeDto> response = employeeController.activateEmployee(1L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(EmployeeStatus.ACTIVE, employeeModel.getStatus());
    }
    @Test
    void getEmployees_WhenMapperFails_ShouldThrowException() {
        // Arrange
        when(employeeService.findAll()).thenReturn(Arrays.asList(employeeModel));
        when(employeeMapper.convertToDto(any(EmployeeModel.class))).thenThrow(new RuntimeException("Mapping failed"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> employeeController.getEmployees());
    }

}