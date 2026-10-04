package com.detrox.helpdesk.help_desk_backend.serviceImpl;

import com.detrox.helpdesk.help_desk_backend.entity.Ticket;
import com.detrox.helpdesk.help_desk_backend.repository.TicketRepository;
import com.detrox.helpdesk.help_desk_backend.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {


    private final TicketRepository ticketRepository;

    // create Ticket
    @Override
    @Transactional
    public Ticket createTicket(Ticket ticket){
        ticket.setId(null);
        return ticketRepository.save(ticket);
    }

    // update Ticket
    @Override
    @Transactional
    public Ticket updateTicket(Ticket ticket) {

        Ticket existingTicket = ticketRepository.findById(ticket.getId())
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        existingTicket.setSummary(ticket.getSummary());
        existingTicket.setPriority(ticket.getPriority());
        existingTicket.setStatus(ticket.getStatus());
        existingTicket.setEmail(ticket.getEmail());

        return ticketRepository.save(existingTicket);
    }

    // get Ticket
    @Override
    public Ticket getTicket(Long ticketId){
        return ticketRepository.findById(ticketId).orElse(null);
    }

    // get Ticket by username
    @Override
    public Ticket getTicketByEmail(String email){
        return ticketRepository.findByEmail(email).orElse(null);
    }


}
