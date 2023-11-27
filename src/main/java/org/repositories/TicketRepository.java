package org.repositories;

import org.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    Map<Integer,Ticket> tickets=new HashMap<>();
    int prevId=0;
    public Ticket saveTicket(Ticket ticket){
        prevId++;
        tickets.put(prevId,ticket);
        return tickets.get(prevId);
    }
}
