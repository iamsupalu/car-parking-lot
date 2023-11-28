package org.strategies.SpotAllocationStrategies;

import org.models.Gate;
import org.models.ParkingSpot;
import org.models.Vehicle;
import org.models.VehicleType;

public class NearestSpotAllocationStrategy implements SpotAllocationStrategy{

    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) {
        return new ParkingSpot();
    }
}
