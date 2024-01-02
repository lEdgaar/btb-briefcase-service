package com.btb.briefcaseservice.controller;

import com.btb.briefcaseservice.dto.AddDashboardBriefcase;
import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.entity.DashboardsBriefcase;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.service.DashboardsBriefcaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private DashboardsBriefcaseService dashboardsBriefcaseService;


    public DashboardController(DashboardsBriefcaseService dashboardsBriefcaseService) {
        this.dashboardsBriefcaseService = dashboardsBriefcaseService;
    }

    @GetMapping("/briefcase/{briefcaseId}")
    public List<DashboardsBriefcase> getDashboardById(@PathVariable("briefcaseId") Long briefcaseId) throws BriefcaseException {
        log.info("Briefcase: Get Briefcase by id: {}", briefcaseId);

        log.info("Event: Get Briefcase by id: {}", briefcaseId);
        return dashboardsBriefcaseService.getBriefcaseDashboardsById(briefcaseId);
    }

    @PostMapping("/")
    public void addDashboardBriefcase(AddDashboardBriefcase addDashboardBriefcase) throws DBException, BriefcaseException {
        log.info("Briefcase: Add dashboard briefcase");

        log.info("Event: Add dashboard briefcase");
        dashboardsBriefcaseService.addDashboardBriefcase(addDashboardBriefcase);
    }

    @DeleteMapping("/{briefcaseId}")
    public void deleteDashboardBriefcase(@PathVariable("briefcaseId") Long briefcaseId) {
        log.info("Briefcase: Delete Briefcase by id: {}", briefcaseId);

        log.info("Event: Delete Briefcase by id: {}", briefcaseId);
        dashboardsBriefcaseService.deleteDashboardBriefcase(briefcaseId);
    }

}
