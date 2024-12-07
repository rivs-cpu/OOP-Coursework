package com.example.ticketingsystem.scheduler;

import com.example.ticketingsystem.thread.Customer;
import com.example.ticketingsystem.thread.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Autowired
    private Vendor vendor;

    @Autowired
    private Customer customer;

    //Schedule vendor thread to run every 5 seconds
    @Scheduled (fixedRate = 5000)
    public void scheduleVendor(){
        new Thread(vendor).start();
    }

    //Schedule customer thread to run every 3 seconds
    @Scheduled(fixedRate = 3000)
    public void scheduleCustomer(){
        new Thread(customer).start();
    }
}
