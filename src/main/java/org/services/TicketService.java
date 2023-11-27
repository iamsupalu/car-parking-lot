package org.services;

import org.exceptions.GateNotFoundException;
import org.exceptions.SpotNotFoundException;
import org.models.*;
import org.repositories.GateRepository;
import org.repositories.ParkingLotRepository;
import org.repositories.TicketRepository;
import org.repositories.VehicleRepository;
import org.strategies.SpotAllocationStrategies.SpotAllocationStrategy;
import org.strategies.SpotAllocationStrategies.SpotAllocationStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    GateRepository gateRepository;
    TicketRepository ticketRepository;
    ParkingLotRepository parkingLotRepository;
    VehicleRepository vehicleRepository;

    public TicketService(GateRepository gateRepository,
                         TicketRepository ticketRepository,
                         ParkingLotRepository parkingLotRepository,
                         VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
    }

    /*
            check if vehicle is there in db
            if exists get vehicle
            else crete vehicle
            assign spot
            assign time
            crete ticket number
            create ticket
             */
    public Ticket issueTicket(int gateId,
                              String vehicleNumber,
                              VehicleType vehicleType,
                              String vehicleOwnerName
                              ) throws GateNotFoundException, SpotNotFoundException {
        Ticket ticket=new Ticket();

        Optional<Gate> gateOutput=gateRepository.findGateById(gateId);
        if(gateOutput.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate gate= gateOutput.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        Vehicle vehicle;
        Optional<Vehicle> vehicleOutput=vehicleRepository.findVehicleByNumber(vehicleNumber);
        if(vehicleOutput.isEmpty()){
            vehicle=new Vehicle();
            vehicle.setVehicleType(vehicleType);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
        }
        else{
            vehicle=vehicleOutput.get();
        }
        ticket.setVehicle(vehicle);

        ticket.setEntryTime(new Date());

        SpotAllocationStrategyType strategyType=parkingLotRepository.findStrategyTypeByGate(gate);
        SpotAllocationStrategy spotAllocationStrategy= SpotAllocationStrategyFactory.getStrategyByType(strategyType);


        if(spotAllocationStrategy.getSpot(gate,vehicleType)!=null){
            ticket.setParkingSpot(spotAllocationStrategy.getSpot(gate,vehicleType));
        }
        else throw new SpotNotFoundException();

        ticket.setTicketNumber("T"+vehicleNumber+ticket.getEntryTime());
        return ticketRepository.saveTicket(ticket);
    }
}
