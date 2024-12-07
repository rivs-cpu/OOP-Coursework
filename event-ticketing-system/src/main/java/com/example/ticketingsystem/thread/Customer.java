package com.example.ticketingsystem.thread;

import com.example.ticketingsystem.model.Ticket;
import com.example.ticketingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class Customer implements Runnable {
    @Autowired private TicketService ticketService;
    @Override public void run(){
        Random random = new Random();
        while (true) {
            try {
                //stimulate ticket purchase
                List<Ticket> tickets = ticketService.getAllTickets();
                if (!tickets.isEmpty()) {
                    Ticket ticket = tickets.get(random.nextInt(tickets.size()));
                    ticketService.purchaseTicket(ticket.getId());
                    System.out.println("Customer purchased a ticket: " + ticket.getEvent());
                } Thread.sleep(3000); //wait for 3 seconds before attempting another purchase
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
