package com.detrox.helpdesk.help_desk_backend.tools;

import com.detrox.helpdesk.help_desk_backend.entity.Ticket;
import com.detrox.helpdesk.help_desk_backend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    // create Ticket tool
    @Tool(description = "This tool helps to create a new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket details") Ticket ticket){
        return ticketService.createTicket(ticket);
    }

    // get ticket by username
    @Tool(description = "This tool help to get ticket by username")
    public Ticket getTicketByUsername(@ToolParam(description = "user whose ticket is required")
                                          String username){
        return ticketService.getTicketByUsername(username);
    }

    // update Ticket
    @Tool(description = "This tool helps to update the ticket")
    public Ticket updateTicket(@ToolParam(description = "new ticket detail with ticket id") Ticket ticket){
        return ticketService.updateTicket(ticket,ticket.getId());
    }

    // get current system time
    @Tool(description = "This tool helps to get current system time")
    public String getCurrentTime(){
        return String.valueOf(System.currentTimeMillis());
    }

}
