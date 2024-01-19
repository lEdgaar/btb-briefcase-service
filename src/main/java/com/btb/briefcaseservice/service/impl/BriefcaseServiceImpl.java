package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.dto.AddBriefcaseDTO;
import com.btb.briefcaseservice.dto.UpdateBriefcaseDTO;
import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.entity.Transaction;
import com.btb.briefcaseservice.exception.*;
import com.btb.briefcaseservice.persistence.mapper.BriefcaseMapper;
import com.btb.briefcaseservice.persistence.mapper.TransactionMapper;
import com.btb.briefcaseservice.service.BriefcaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class BriefcaseServiceImpl implements BriefcaseService {

    @Autowired
    private BriefcaseMapper briefcaseMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public void addBriefcase(AddBriefcaseDTO addBriefcaseDTO) throws DBException {
        log.info("Adding briefcase: {}", addBriefcaseDTO.getUserId());

        Briefcase briefcase = new Briefcase();
        briefcase.setUserId(addBriefcaseDTO.getUserId());
        briefcase.setCreatedAt(new Date());
        briefcase.setName(addBriefcaseDTO.getName());
        briefcase.setIsActive(true);
        briefcase.setEnableSocialTrading(addBriefcaseDTO.getEnableSocialTrading());

        if (briefcaseMapper.save(briefcase) != 1) {
            throw new DBException("Error adding briefcase");
        }

        log.info("Briefcase: {} added", addBriefcaseDTO.getUserId());
    }

    @Override
    public void updateBriefcase(Long briefcaseId, UpdateBriefcaseDTO updateBriefcaseDTO) throws DBException {
        log.info("Updating briefcase: {}", briefcaseId);

        Briefcase briefcase = briefcaseMapper.findById(briefcaseId);
        briefcase.setName(updateBriefcaseDTO.getName());
        briefcase.setEnableSocialTrading(updateBriefcaseDTO.getEnableSocialTrading());

        if (briefcaseMapper.update(briefcase) != 1) {
            throw new DBException("Error updating briefcase");
        }

        log.info("Briefcase: {} updated", briefcaseId);
    }

    @Override
    public void deleteBriefcase(Long briefcaseId) throws DBException {
        log.info("Deleting briefcase: {}", briefcaseId);

        Briefcase briefcase = briefcaseMapper.findById(briefcaseId);
        briefcase.setIsActive(false);

        if (briefcaseMapper.update(briefcase) != 1) {
            throw new DBException("Error updating briefcase");
        }

        log.info("Briefcase: {} deleted", briefcaseId);
    }

    @Override
    public List<Briefcase> getBriefcaseListByUserId(Long id) {
        log.info("Getting briefcase: {}", id);

        Briefcase briefcase = new Briefcase();
        briefcase.setUserId(id);

        List<Briefcase> briefcaseList = briefcaseMapper.findByFilter(briefcase);

        log.info("Event: Get briefcase");
        return briefcaseList;
    }

    @Override
    public Briefcase getBriefcaseById(Long id) throws BriefcaseException {
        log.info("Getting briefcase: {}", id);

        log.info("Event: Get briefcase");
        return findBriefcaseByid(id);
    }

    @Override
    public Double getTaxes(Long briefcaseId) {
        log.info("Getting taxes: {}", briefcaseId);

        Briefcase briefcase = briefcaseMapper.findById(briefcaseId);

        Transaction transaction = new Transaction();
        transaction.setBriefcase(briefcase);

        List<Transaction> transactionList = transactionMapper.findByFilter(transaction);

        Double total = 0.0;
        for (Transaction data : transactionList) {
            total += data.getQuantity() * data.getPriceUnit();
        }

        return total * 0.15;
    }

    private Briefcase findBriefcaseByid(Long briefcaseId) throws BriefcaseException {
        log.info("Getting briefcase: {}", briefcaseId);
        if (briefcaseId == null) {
            throw new BriefcaseException(BriefcaseErrorCodes.BRIEFCASE_ID_NOT_NULL, BriefcaseErrorCodes.BRIEFCASE_ID_NOT_NULL.getKey());
        }

        Briefcase briefcase = briefcaseMapper.findById(briefcaseId);

        if (briefcase == null) {
            throw new BriefcaseException(BriefcaseErrorCodes.BRIEFCASE_NOT_FOUND, BriefcaseErrorCodes.BRIEFCASE_NOT_FOUND.getKey());
        }

        log.info("Briefcase found: {}", briefcase.getUserId());

        return briefcase;
    }

}
