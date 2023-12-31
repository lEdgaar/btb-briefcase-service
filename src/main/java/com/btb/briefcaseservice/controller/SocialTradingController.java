package com.btb.briefcaseservice.controller;

import com.btb.briefcaseservice.entity.Briefcase;
import com.btb.briefcaseservice.exception.DBException;
import com.btb.briefcaseservice.service.SocialTradingFollowersService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/social-trading")
public class SocialTradingController {

    private SocialTradingFollowersService socialTradingFollowersService;

    @Autowired
    public SocialTradingController(SocialTradingFollowersService socialTradingFollowersService) {
        this.socialTradingFollowersService = socialTradingFollowersService;
    }

    @PostMapping("/")
    public @ResponseBody List<Briefcase> showSocialTradingBriefcase() {
        log.info("SocialTrading: Show SocialTradingBriefcase");

        log.info("Event: Show SocialTradingBriefcase");
        return socialTradingFollowersService.showSocialTradingBriefcase();
    }

    @PostMapping("/copy/{sourceBriefcaseId}/{brokerId}")
    public void copySocialTradingBriefcase(@PathVariable("sourceBriefcaseId") Long sourceBriefcaseId, @PathVariable("brokerId") Long brokerId) throws DBException {
        log.info("SocialTrading: Copy SocialTradingBriefcase from {} to {}", sourceBriefcaseId, brokerId);

        log.info("Event: Copy SocialTradingBriefcase from {} to {}", sourceBriefcaseId, brokerId);
        socialTradingFollowersService.copySocialTradingBriefcase(sourceBriefcaseId, brokerId);
    }

    @PostMapping("/delete/{sourceBriefcaseId}/{brokerId}")
    public void deleteSocialTradingBriefcase(@PathVariable("sourceBriefcaseId") Long sourceBriefcaseId, @PathVariable("brokerId") Long brokerId) {
        log.info("SocialTrading: Delete SocialTradingBriefcase from {} to {}", sourceBriefcaseId, brokerId);

        log.info("Event: Delete SocialTradingBriefcase from {} to {}", sourceBriefcaseId, brokerId);
        socialTradingFollowersService.deleteSocialTradingBriefcase(sourceBriefcaseId, brokerId);
    }

}
