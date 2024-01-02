package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.exception.DBException;

import java.util.List;

public interface SocialTradingFollowersService {

    List<Briefcase> showSocialTradingBriefcase();

    void copySocialTradingBriefcase(Long sourceBriefcaseId, Long brokerId) throws DBException;

    void deleteSocialTradingBriefcase(Long socialTradingBriefcaseId, Long brokerId);

}
