package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.service.DashboardsBriefcaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class DashboardsBriefcaseServiceImpl implements DashboardsBriefcaseService {

    @Override
    public Briefcase getBriefcaseById(Long id) {
        return null;
    }

    @Override
    public void addDashboardBriefcase(Briefcase briefcase) {

    }

    @Override
    public void updateDashboardBriefcase(Long briefcaseId) {

    }

    @Override
    public void deleteDashboardBriefcase(Long briefcaseId) {

    }
}
