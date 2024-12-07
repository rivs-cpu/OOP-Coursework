package com.example.ticketingsystem.thread;

import com.example.ticketingsystem.model.Ticket;
import com.example.ticketingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Vendor implements Runnable {
    @Autowired
    private TicketService ticketService;

    @Override
    public void run(){
        Random random = new Random();
        while (true){
            try {
                //stimulate ticket release
                Ticket ticket = new Ticket();
                ticket.setEvent("Event" + random.nextInt(100));
                ticket.setAvailable(true);
                ticketService.addTicket(ticket);
                System.out.println("Vendor added a ticket: " + ticket.getEvent());
                Thread.sleep(5000); //wait for 5 seconds before adding another ticket
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
