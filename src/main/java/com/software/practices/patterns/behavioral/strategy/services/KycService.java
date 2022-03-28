package com.software.practices.patterns.behavioral.strategy.services;

import com.software.practices.patterns.behavioral.strategy.enums.KycStrategyName;
import com.software.practices.patterns.behavioral.strategy.factories.KycStrategyFactory;
import com.software.practices.patterns.behavioral.strategy.strategies.KycStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KycService {

    @Autowired
    private KycStrategyFactory kycStrategyFactory;

    public void doKyc() {

        KycStrategy kycStrategy =
                kycStrategyFactory.getStrategy(KycStrategyName.DIGITAL_KYC);
        kycStrategy.doKYC();
    }
}