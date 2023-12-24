package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.service.SocialTradingFollowersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class SocialTradingFollowersServiceImpl implements SocialTradingFollowersService {


    @Override
    public List<Briefcase> showSocialTradingBriefcase() {
        return null;
    }

    @Override
    public void copySocialTradingBriefcase(Long sourceBriefcaseId, Long brokerId) {

    }

    @Override
    public void deleteSocialTradingBriefcase(Long socialTradingBriefcaseId, Long brokerId) {

    }
}
