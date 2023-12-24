package com.btb.briefcaseservice.controller;

import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.service.DashboardsBriefcaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private DashboardsBriefcaseService dashboardsBriefcaseService;


    public DashboardController(DashboardsBriefcaseService dashboardsBriefcaseService) {
        this.dashboardsBriefcaseService = dashboardsBriefcaseService;
    }

    public Briefcase getDashboardById(Long id) {
        log.info("Briefcase: Get Briefcase by id: {}", id);

        log.info("Event: Get Briefcase by id: {}", id);
        return dashboardsBriefcaseService.getBriefcaseById(id);
    }

    public void addDashboardBriefcase(Briefcase briefcase) {
        log.info("Briefcase: Add Briefcase: {}", briefcase);

        log.info("Event: Add Briefcase: {}", briefcase);
        dashboardsBriefcaseService.addDashboardBriefcase(briefcase);
    }

    public void updateDashboardBriefcase(Long briefcaseId) {
        log.info("Briefcase: Update Briefcase by id: {}", briefcaseId);

        log.info("Event: Update Briefcase by id: {}", briefcaseId);
        dashboardsBriefcaseService.updateDashboardBriefcase(briefcaseId);

    }

    public void deleteDashboardBriefcase(Long briefcaseId) {
        log.info("Briefcase: Delete Briefcase by id: {}", briefcaseId);

        log.info("Event: Delete Briefcase by id: {}", briefcaseId);
        dashboardsBriefcaseService.deleteDashboardBriefcase(briefcaseId);
    }

}
