package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.dto.AddBriefcaseDTO;
import com.btb.briefcaseservice.dto.UpdateBriefcaseDTO;
import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.exception.BriefcaseException;
import com.btb.briefcaseservice.exception.DBException;
import org.springframework.web.bind.annotation.PathVariable;

public interface BriefcaseService {

    void addBriefcase(AddBriefcaseDTO addBriefcaseDTO) throws DBException;

    void updateBriefcase(Long briefcaseId, UpdateBriefcaseDTO updateBriefcaseDTO) throws DBException;

    void deleteBriefcase(Long briefcaseId) throws DBException;

    Briefcase getBriefcaseById(Long id) throws BriefcaseException;

    Double getTaxes(Long briefcaseId);

}
