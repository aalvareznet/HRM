package com.hrm.HRM.controller;

import com.hrm.HRM.model.TrainingModel;
import com.hrm.HRM.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/training")
public class TrainingController {

    @Autowired
    private TrainingService service;

    @PostMapping
    public ResponseEntity<TrainingModel> createTraining(@RequestBody TrainingModel trainingModel){
        TrainingModel model = service.create(trainingModel);
        return ResponseEntity.ok(model);
    }

}
