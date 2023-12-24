package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.dto.AddBriefcaseDTO;
import com.btb.briefcaseservice.dto.UpdateBriefcaseDTO;
import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.service.BriefcaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class BriefcaseServiceImpl implements BriefcaseService {

    @Override
    public void addBriefcase(AddBriefcaseDTO addBriefcaseDTO) {

    }

    @Override
    public void updateBriefcase(UpdateBriefcaseDTO updateBriefcaseDTO) {

    }

    @Override
    public void deleteBriefcase(Long briefcaseId) {

    }

    @Override
    public Briefcase getBriefcaseById(Long id) {
        return null;
    }

    @Override
    public void getRiskManagementTool(Long briefcaseId) {

    }

    @Override
    public void getTaxes(Long briefcaseId) {

    }
}
