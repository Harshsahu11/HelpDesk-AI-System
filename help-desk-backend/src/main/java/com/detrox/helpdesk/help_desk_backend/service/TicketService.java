package com.detrox.helpdesk.help_desk_backend.service;

import com.detrox.helpdesk.help_desk_backend.entity.Ticket;

public interface TicketService {

    Ticket createTicket(Ticket ticket);

    Ticket getTicket(Long ticketId);

    Ticket getTicketByEmail(String email);

    Ticket updateTicket(Ticket ticket);
}
