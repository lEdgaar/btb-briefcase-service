package com.btb.briefcaseservice.controller;

import com.btb.briefcaseservice.dto.AddBriefcaseDTO;
import com.btb.briefcaseservice.dto.UpdateBriefcaseDTO;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.service.BriefcaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/briefcase")
public class BriefcaseController {

    private BriefcaseService briefcaseService;

    @Autowired
    public BriefcaseController(BriefcaseService briefcaseService) {
        this.briefcaseService = briefcaseService;
    }

    @PostMapping("/")
    public void addBriefcase(@RequestBody AddBriefcaseDTO addBriefcaseDTO) throws DBException {
        log.info("Briefcase: Add Briefcase");

        log.info("Event: Add Briefcase");
        briefcaseService.addBriefcase(addBriefcaseDTO);
    }

    @PostMapping("/update/{briefcaseId}")
    public void updateBriefcase(@PathVariable("briefcaseId") Long briefcaseId, @RequestBody UpdateBriefcaseDTO updateBriefcaseDTO) throws DBException {
        log.info("Briefcase: Update Briefcase");

        log.info("Event: Update Briefcase");
        briefcaseService.updateBriefcase(briefcaseId, updateBriefcaseDTO);
    }

    @PostMapping("/delete/{briefcaseId}")
    public void deleteBriefcase(@PathVariable("briefcaseId") Long briefcaseId) throws DBException {
        log.info("Briefcase: Delete Briefcase");

        log.info("Event: Delete Briefcase");
        briefcaseService.deleteBriefcase(briefcaseId);
    }

    @GetMapping("/user/{userId}")
    public void getBriefcaseListByUser(@PathVariable("userId") Long userId) throws BriefcaseException {
        log.info("Briefcase: Get BriefcaseListByUser");

        log.info("Event: Get BriefcaseListByUser");
        briefcaseService.getBriefcaseById(userId);
    }

    @GetMapping("/taxes/{briefcaseId}")
    public Double getTaxes(@PathVariable("briefcaseId") Long briefcaseId) {
        log.info("Briefcase: Get Taxes");

        log.info("Event: Get Taxes");
        return briefcaseService.getTaxes(briefcaseId);
    }
}
