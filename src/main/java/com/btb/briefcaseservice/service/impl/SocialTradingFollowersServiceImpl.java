package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.entity.SocialTradingFollowers;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.persistence.mapper.BriefcaseMapper;
import com.btb.briefcaseservice.persistence.mapper.SocialTradingFollowersMapper;
import com.btb.briefcaseservice.service.SocialTradingFollowersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class SocialTradingFollowersServiceImpl implements SocialTradingFollowersService {

    @Autowired
    private BriefcaseMapper briefcaseMapper;

    @Autowired
    private SocialTradingFollowersMapper socialTradingFollowersMapper;

    @Override
    public List<Briefcase> showSocialTradingBriefcase() {
        log.info("Getting social trading briefcase");

        Briefcase briefcase = new Briefcase();
        briefcase.setEnableSocialTrading(true);

        return briefcaseMapper.findByFilter(briefcase);
    }

    @Override
    public void copySocialTradingBriefcase(Long sourceBriefcaseId, Long brokerId) throws DBException {
        log.info("Copying social trading briefcase: {}", sourceBriefcaseId);

        SocialTradingFollowers socialTradingFollowers = new SocialTradingFollowers();
        socialTradingFollowers.setBriefcase(briefcaseMapper.findById(sourceBriefcaseId));
        socialTradingFollowers.setTimeAt(new Date());
        socialTradingFollowers.setUserId(brokerId);

        if (socialTradingFollowersMapper.save(socialTradingFollowers) != 1) {
            throw new DBException("Error adding social trading");
        }

        log.info("Social trading copied: {}", sourceBriefcaseId);
    }

    @Override
    public void deleteSocialTradingBriefcase(Long socialTradingBriefcaseId, Long brokerId) {
        log.info("Deleting social trading briefcase: {}", socialTradingBriefcaseId);

        SocialTradingFollowers socialTradingFollowers = new SocialTradingFollowers();
        socialTradingFollowers.setBriefcase(briefcaseMapper.findById(socialTradingBriefcaseId));
        socialTradingFollowers.setUserId(brokerId);

        socialTradingFollowers = socialTradingFollowersMapper.findByFilter(socialTradingFollowers).stream().findFirst().orElse(null);

        if (socialTradingFollowers != null) {
            socialTradingFollowersMapper.delete(socialTradingFollowers.getId());
        }

        log.info("Social trading deleted: {}", socialTradingBriefcaseId);
    }
}
