package com.hrm.HRM.service;

import com.hrm.HRM.model.ReportModel;
import com.hrm.HRM.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService extends BaseService<ReportModel, Long>{

    @Autowired
    private ReportRepo reportRepo;

    @Override
    protected ReportRepo getRepository() {
        return reportRepo;
    }

}
