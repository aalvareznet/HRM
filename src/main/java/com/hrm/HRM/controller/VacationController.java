package com.hrm.HRM.controller;

import com.hrm.HRM.model.VacationRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vacation")
public class VacationController {

    @PostMapping("/request")
    public ResponseEntity<VacationRequestModel> createVacationRequest(@RequestBody VacationRequestModel vacationRequestModel){

    }
    @PutMapping("/{id}/approve")
    public ResponseEntity<VacationRequestModel> approveVacationRequest(@PathVariable Long id){

    }
    @PutMapping("/{id}/deny")
    public ResponseEntity<VacationRequestModel> denyVacationRequest(@PathVariable Long id){

    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<VacationRequestModel> cancelVacation(@PathVariable Long id){

    }
    @PutMapping("/{id}/reschedule")
    public ResponseEntity<VacationRequestModel> rescheduleVacation(@PathVariable Long id,
                                                                   @RequestBody VacationRequestModel vacationRequestModel){

    }
}
