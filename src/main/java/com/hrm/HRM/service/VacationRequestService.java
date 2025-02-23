package com.hrm.HRM.service;

import com.hrm.HRM.model.VacationRequestModel;
import com.hrm.HRM.repository.VacationRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationRequestService extends BaseService<VacationRequestModel, Long>{

    @Autowired
    private VacationRequestRepo vacationRequestRepo;

    @Override
    protected VacationRequestRepo getRepository() {
        return vacationRequestRepo;
    }

}
