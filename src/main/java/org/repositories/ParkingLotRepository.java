package org.repositories;

import org.models.Gate;
import org.models.SpotAllocationStrategyType;
import org.strategies.SpotAllocationStrategies.NearestSpotAllocationStrategy;

import java.util.Optional;

public class ParkingLotRepository {
    public SpotAllocationStrategyType findStrategyTypeByGate(Gate gate){

        return SpotAllocationStrategyType.NEAREST;
    }
}
