package com.example.ticketingsystem.service;

import com.example.ticketingsystem.model.Ticket;
import com.example.ticketingsystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    //ReentrantLock to ensure thread safety
    private final ReentrantLock lock = new ReentrantLock();

    //Method to get all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    //Method to add a ticket with thread safety
    public Ticket addTicket(Ticket ticket) {
        lock.lock(); //Acquire the lock
        try {
            return ticketRepository.save(ticket);
        } finally {
            lock.unlock(); //Release the lock
        }
    }

    //Method to purchase a ticket with thread safety
    public Ticket purchaseTicket(Long id){
        lock.lock(); //Acquire the lock
        try {
            Ticket ticket = ticketRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Ticket not found"));
            if (ticket.isAvailable()){
                ticket.setAvailable(false);
                return ticketRepository.save(ticket);
            } else {
                throw new RuntimeException("Ticket already sold");
            }
        } finally {
            lock.unlock(); //Release the lock
        }
    }
    //Method to delete a ticket
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}