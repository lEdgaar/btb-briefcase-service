package com.btb.briefcaseservice.controller;

import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.service.IATradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/ia-trading")
public class IATradingController {

    private IATradingService iaTradingService;

    @Autowired
    public IATradingController(IATradingService iaTradingService) {
        this.iaTradingService = iaTradingService;
    }

    @GetMapping("/feedback/{assetId}")
    public Assets getIAFeedback() {
        log.info("IATrading: Get IAFeedback");

        log.info("Event: Get IAFeedback");
        return iaTradingService.getIAFeedback();
    }

    @GetMapping("/copilot/{assetId}")
    public void copilotTrading() {
        log.info("IATrading: CopilotTrading");

        log.info("Event: CopilotTrading");
        iaTradingService.copilotTrading();
    }

}
