package org;

import org.DTOs.IssueTicketRequestDto;
import org.controllers.TicketContoller;
import org.models.Ticket;
import org.models.VehicleType;
import org.repositories.GateRepository;
import org.repositories.ParkingLotRepository;
import org.repositories.TicketRepository;
import org.repositories.VehicleRepository;
import org.services.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository=new GateRepository();
        TicketRepository ticketRepository=new TicketRepository();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        VehicleRepository vehicleRepository=new VehicleRepository();

        TicketService ticketService=new TicketService(gateRepository,
                ticketRepository,
                parkingLotRepository,
                vehicleRepository);

        TicketContoller ticketContoller=new TicketContoller(ticketService);

        IssueTicketRequestDto issueTicketRequestDto=new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(1);
        issueTicketRequestDto.setVehicleNumber("HR26");
        issueTicketRequestDto.setVehicleType(VehicleType.TWO_WHEELER);
        issueTicketRequestDto.setOwnerName("Kumar");

        Ticket ticket=ticketContoller.issueTicket(issueTicketRequestDto).getTicket();
        System.out.println(ticket);
    }
}
