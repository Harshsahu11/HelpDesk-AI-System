package com.detrox.helpdesk.help_desk_backend.serviceImpl;

import com.detrox.helpdesk.help_desk_backend.entity.Ticket;
import com.detrox.helpdesk.help_desk_backend.repository.TicketRepository;
import com.detrox.helpdesk.help_desk_backend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;

    // create Ticket
    @Override
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    // update Ticket
    @Override
    public Ticket updateTicket(Ticket ticket, Long ticketId) {

        Ticket existingTicket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        existingTicket.setSummary(ticket.getSummary());
        existingTicket.setPriority(ticket.getPriority());
        existingTicket.setStatus(ticket.getStatus());
        existingTicket.setUsername(ticket.getUsername());

        return ticketRepository.save(existingTicket);
    }

    // get Ticket
    @Override
    public Ticket getTicket(Long ticketId){
        return ticketRepository.findById(ticketId).orElse(null);
    }

    // get Ticket by username
    @Override
    public Ticket getTicketByUsername(String username){
        return ticketRepository.findByUsername(username).orElse(null);
    }


}
