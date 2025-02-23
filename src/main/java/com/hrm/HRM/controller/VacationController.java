package com.hrm.HRM.controller;

import com.hrm.HRM.enums.VacationStatus;
import com.hrm.HRM.model.VacationRequestModel;
import com.hrm.HRM.service.VacationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vacation")
public class VacationController {

    @Autowired
    private VacationRequestService service;

    @PostMapping("/request")
    public ResponseEntity<VacationRequestModel> createVacationRequest(@RequestBody VacationRequestModel vacationRequestModel){
        VacationRequestModel request = service.create(vacationRequestModel);
        return ResponseEntity.ok(request);
    }
    @PutMapping("/{id}/approve")
    public ResponseEntity<VacationRequestModel> approveVacationRequest(@PathVariable Long id){
        Optional<VacationRequestModel> request = service.findById(id);
        if (request.isPresent()){
            VacationRequestModel requestToApprove = request.get();
            if(requestToApprove.getStatus() != VacationStatus.APPROVED){
                requestToApprove.setStatus(VacationStatus.APPROVED);
                VacationRequestModel updatedVacation = service.update(requestToApprove);
                return ResponseEntity.ok(updatedVacation);
            }
            return ResponseEntity.ok(requestToApprove);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}/deny")
    public ResponseEntity<VacationRequestModel> denyVacationRequest(@PathVariable Long id){
        Optional<VacationRequestModel> request = service.findById(id);
        if (request.isPresent()){
            VacationRequestModel requestToApprove = request.get();
            if(requestToApprove.getStatus() != VacationStatus.REJECTED){
                requestToApprove.setStatus(VacationStatus.REJECTED);
                VacationRequestModel updatedVacation = service.update(requestToApprove);
                return ResponseEntity.ok(updatedVacation);
            }
            return ResponseEntity.ok(requestToApprove);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}/cancel")
    public ResponseEntity<VacationRequestModel> cancelVacation(@PathVariable Long id){
        Optional<VacationRequestModel> request = service.findById(id);
        if (request.isPresent()){
            VacationRequestModel requestToApprove = request.get();
            if(requestToApprove.getStatus() != VacationStatus.CANCELLED){
                requestToApprove.setStatus(VacationStatus.CANCELLED);
                VacationRequestModel updatedVacation = service.update(requestToApprove);
                return ResponseEntity.ok(updatedVacation);
            }
            return ResponseEntity.ok(requestToApprove);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}/reschedule")
    public ResponseEntity<VacationRequestModel> rescheduleVacation(@PathVariable Long id,
                                                                   @RequestBody VacationRequestModel vacationRequestModel){
        Optional<VacationRequestModel> request = service.findById(id);
        if(request.isPresent()){
            VacationRequestModel requestToUpdate = request.get();
            requestToUpdate.setStartDate(vacationRequestModel.getStartDate());
            requestToUpdate.setEndDate(vacationRequestModel.getEndDate());
            VacationRequestModel updatedRequest = service.update(requestToUpdate);
            return ResponseEntity.ok(updatedRequest);
        }
        return ResponseEntity.notFound().build();
    }
}
