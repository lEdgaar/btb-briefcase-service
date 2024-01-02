package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.dto.AddDashboardBriefcase;
import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.entity.DashboardsBriefcase;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.persistence.mapper.DashboardsBriefcaseMapper;
import com.btb.briefcaseservice.service.BriefcaseService;
import com.btb.briefcaseservice.service.DashboardsBriefcaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class DashboardsBriefcaseServiceImpl implements DashboardsBriefcaseService {

    @Autowired
    private BriefcaseService briefcaseService;

    @Autowired
    private DashboardsBriefcaseMapper dashboardsBriefcaseMapper;

    @Override
    public List<DashboardsBriefcase> getBriefcaseDashboardsById(Long id) throws BriefcaseException {
        log.info("Get briefcase by id: {}", id);

        DashboardsBriefcase dashboardsBriefcase = new DashboardsBriefcase();
        dashboardsBriefcase.setBriefcase(briefcaseService.getBriefcaseById(id));

        return dashboardsBriefcaseMapper.findByFilter(dashboardsBriefcase);
    }

    @Override
    public void addDashboardBriefcase(AddDashboardBriefcase addDashboardBriefcase) throws BriefcaseException, DBException {
        log.info("Add dashborad briefcase");

        DashboardsBriefcase dashboardsBriefcase = new DashboardsBriefcase();
        dashboardsBriefcase.setBriefcase(briefcaseService.getBriefcaseById(addDashboardBriefcase.getBriefcaseId()));
        dashboardsBriefcase.setOrder(addDashboardBriefcase.getOrder());
        dashboardsBriefcase.setFilterColumn(addDashboardBriefcase.getFilterColumn());

        if (dashboardsBriefcaseMapper.update(dashboardsBriefcase) != 1) {
            throw new DBException("Error updating dashboards briefcase");
        }

        log.info("Dashborad briefcase added");
    }

    @Override
    public void deleteDashboardBriefcase(Long briefcaseId) {
        log.info("Delete dashborad briefcase: briefcaseId: {}", briefcaseId);

        dashboardsBriefcaseMapper.delete(briefcaseId);
        log.info("Dashborad briefcase deleted");
    }
}
