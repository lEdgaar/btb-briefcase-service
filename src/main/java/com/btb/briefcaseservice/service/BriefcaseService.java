package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.dto.AddBriefcaseDTO;
import com.btb.briefcaseservice.dto.UpdateBriefcaseDTO;
import com.btb.briefcaseservice.entity.Briefcase;

public interface BriefcaseService {

    void addBriefcase(AddBriefcaseDTO addBriefcaseDTO);

    void updateBriefcase(UpdateBriefcaseDTO updateBriefcaseDTO);

    void deleteBriefcase(Long briefcaseId);

    Briefcase getBriefcaseById(Long id);

    void getRiskManagementTool(Long briefcaseId);

    void getTaxes(Long briefcaseId);

}
