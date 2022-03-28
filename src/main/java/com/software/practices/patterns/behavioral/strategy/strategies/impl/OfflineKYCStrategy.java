package com.software.practices.patterns.behavioral.strategy.strategies.impl;

import com.software.practices.patterns.behavioral.strategy.enums.KycStrategyName;
import com.software.practices.patterns.behavioral.strategy.strategies.KycStrategy;
import org.springframework.stereotype.Component;

@Component
public class OfflineKYCStrategy implements KycStrategy {

    @Override
    public void doKYC() {

    }

    @Override
    public KycStrategyName getName() {
        return KycStrategyName.OFFLINE_KYC;
    }
}