package org.strategies.SpotAllocationStrategies;

import org.models.Gate;
import org.models.ParkingSpot;
import org.models.Vehicle;
import org.models.VehicleType;

public interface SpotAllocationStrategy {
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType);
}
