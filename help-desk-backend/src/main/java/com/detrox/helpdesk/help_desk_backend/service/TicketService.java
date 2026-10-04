package com.detrox.helpdesk.help_desk_backend.service;

import com.detrox.helpdesk.help_desk_backend.entity.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Ticket getTicket(Long ticketId);

    Ticket getTicketByUsername(String username);

    Ticket updateTicket(Ticket ticket, Long ticketId);
}
