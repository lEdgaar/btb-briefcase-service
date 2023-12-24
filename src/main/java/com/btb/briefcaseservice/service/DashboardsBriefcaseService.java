package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.entity.Briefcase;

public interface DashboardsBriefcaseService {

    Briefcase getBriefcaseById(Long id);

    void addDashboardBriefcase(Briefcase briefcase);

    void updateDashboardBriefcase(Long briefcaseId);

    void deleteDashboardBriefcase(Long briefcaseId);

}
