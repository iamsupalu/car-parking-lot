package org.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String address;
    private List<Gate> entryGates;
    private List<Gate> exitGates;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> allowedVehiclesTypes;
    private List<ParkingFloor> parkingFloors;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private SpotAllocationStrategyType slotAllocationStrategyType;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Gate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<Gate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<Gate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<Gate> exitGates) {
        this.exitGates = exitGates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getAllowedVehiclesTypes() {
        return allowedVehiclesTypes;
    }

    public void setAllowedVehiclesTypes(List<VehicleType> allowedVehiclesTypes) {
        this.allowedVehiclesTypes = allowedVehiclesTypes;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public SpotAllocationStrategyType getSlotAllocationStrategyType() {
        return slotAllocationStrategyType;
    }

    public void setSlotAllocationStrategyType(SpotAllocationStrategyType slotAllocationStrategyType) {
        this.slotAllocationStrategyType = slotAllocationStrategyType;
    }
}
