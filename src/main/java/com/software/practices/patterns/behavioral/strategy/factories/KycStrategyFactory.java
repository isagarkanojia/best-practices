package com.software.practices.patterns.behavioral.strategy.factories;

import com.software.practices.patterns.behavioral.strategy.enums.KycStrategyName;
import com.software.practices.patterns.behavioral.strategy.strategies.KycStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class KycStrategyFactory {

    private Map<KycStrategyName, KycStrategy> strategies;

    @Autowired
    public KycStrategyFactory(Set<KycStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public KycStrategy getStrategy(KycStrategyName strategyName) {
        return strategies.get(strategyName);
    }

    private void createStrategy(Set<KycStrategy> strategySet) {
        strategies = new HashMap<>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getName(), strategy));
    }
}