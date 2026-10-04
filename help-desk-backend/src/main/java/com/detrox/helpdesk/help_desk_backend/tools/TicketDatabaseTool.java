package com.detrox.helpdesk.help_desk_backend.tools;

import com.detrox.helpdesk.help_desk_backend.entity.Ticket;
import com.detrox.helpdesk.help_desk_backend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TicketDatabaseTool {

    private final TicketService ticketService;

    // create Ticket tool
    @Tool(description = "This tool helps to create new ticket in database.")
    public Ticket createTicketTool(@ToolParam(description = "Ticket fields required to create new ticket") Ticket ticket) {
        try {
            System.out.println("going to create ticket");
            System.out.println(ticket);
            return ticketService.createTicket(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // get ticket by username
    @Tool(description = "This tool help to get ticket by username")
    public Ticket getTicketByUsername(@ToolParam(description = "user whose ticket is required")
                                          String email){
        return ticketService.getTicketByEmail(email);
    }

    // update Ticket
    @Tool(description = "This tool helps to update ticket.")
    public Ticket updateTicket(@ToolParam(description = "new ticket fields required to update with ticket id.") Ticket ticket) {
        return ticketService.updateTicket(ticket);
    }

    // get current system time
    @Tool(description = "This tool helps to get current system time")
    public String getCurrentTime(){
        return LocalDateTime.now().toString();
    }

}
