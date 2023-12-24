package com.btb.briefcaseservice.service;

import com.btb.briefcaseservice.entity.Assets;

public interface IATradingService {

    Assets getIAFeedback();

    void copilotTrading();

}
