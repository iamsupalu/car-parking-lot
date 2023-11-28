package org.controllers;

import org.DTOs.IssueTicketRequestDto;
import org.DTOs.IssueTicketResponseDto;
import org.DTOs.ResponseStatus;
import org.models.Ticket;
import org.services.TicketService;

public class TicketContoller {
    TicketService ticketService;

    public TicketContoller(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto request){
        IssueTicketResponseDto issueTicketResponseDto=new IssueTicketResponseDto();

        Ticket ticket;
        try{
            ticket=ticketService.issueTicket(request.getGateId(),
                    request.getVehicleNumber(),
                    request.getVehicleType(),
                    request.getOwnerName());
        }
        catch (Exception e){
            issueTicketResponseDto.setErrorMessage(e.getMessage());
            issueTicketResponseDto.setResponseStatus(ResponseStatus.ERROR);
            return issueTicketResponseDto;
        }

        issueTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        issueTicketResponseDto.setTicket(ticket);
        return issueTicketResponseDto;
    }
}
