package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.model.Ticket;
import com.example.ticketingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //to get all tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    //to add a new ticket
    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket) {
        return ticketService.addTicket(ticket);
    }

    //to purchase a ticket
    @PostMapping("/purchase/{id}")
    public Ticket purchaseTicket(@PathVariable Long id) {
        return ticketService.purchaseTicket(id);
    }

    //to delete a ticket
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
