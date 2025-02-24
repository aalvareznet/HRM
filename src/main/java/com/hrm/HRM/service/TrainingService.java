package com.hrm.HRM.service;

import com.hrm.HRM.model.TrainingModel;
import com.hrm.HRM.repository.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService extends BaseService<TrainingModel, Long>{
    @Autowired
    private TrainingRepo trainingRepo;

    @Override
    protected TrainingRepo getRepository() {
        return trainingRepo;
    }

}
