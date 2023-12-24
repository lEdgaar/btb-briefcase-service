package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.entity.Briefcase;

import java.util.List;

public interface SocialTradingFollowersService {

    List<Briefcase> showSocialTradingBriefcase();

    void copySocialTradingBriefcase(Long sourceBriefcaseId, Long brokerId);

    void deleteSocialTradingBriefcase(Long socialTradingBriefcaseId, Long brokerId);

}
