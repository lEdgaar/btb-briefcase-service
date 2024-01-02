package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.dto.AddDashboardBriefcase;
import com.btb.briefcaseservice.entity.DashboardsBriefcase;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;

import java.util.List;

public interface DashboardsBriefcaseService {

    List<DashboardsBriefcase> getBriefcaseDashboardsById(Long id) throws BriefcaseException;

    void addDashboardBriefcase(AddDashboardBriefcase addDashboardBriefcase) throws BriefcaseException, DBException;

    void deleteDashboardBriefcase(Long briefcaseId);

}
