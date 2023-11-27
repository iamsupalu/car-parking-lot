package org.strategies.SpotAllocationStrategies;

import org.models.SpotAllocationStrategyType;

public class SpotAllocationStrategyFactory {
    public static SpotAllocationStrategy getStrategyByType(SpotAllocationStrategyType spotAllocationStrategyType){
        if(spotAllocationStrategyType==SpotAllocationStrategyType.RANDOM){
            return new RandomSpotAllocationStrategy();
        } else if (spotAllocationStrategyType==SpotAllocationStrategyType.NEAREST) {
            return new NearestSpotAllocationStrategy();
        }
        return null;
    }
}
