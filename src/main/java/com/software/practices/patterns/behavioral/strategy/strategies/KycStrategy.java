package com.software.practices.patterns.behavioral.strategy.strategies;

import com.software.practices.patterns.behavioral.strategy.enums.KycStrategyName;

public interface KycStrategy {

    void doKYC();

    KycStrategyName getName();
}