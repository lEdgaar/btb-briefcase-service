package com.btb.briefcaseservice.service.impl;

import com.btb.briefcaseservice.entity.Assets;
import com.btb.briefcaseservice.service.IATradingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class IATradingServiceImpl implements IATradingService {

    @Override
    public Assets getIAFeedback() {
        return null;
    }

    @Override
    public void copilotTrading() {

    }
}
