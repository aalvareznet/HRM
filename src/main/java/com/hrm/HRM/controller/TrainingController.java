package com.hrm.HRM.controller;

import com.hrm.HRM.model.TrainingModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/training")
public class TrainingController {
    @PostMapping
    public ResponseEntity<TrainingModel> createTraining(@RequestBody TrainingModel trainingModel){

    }

}
