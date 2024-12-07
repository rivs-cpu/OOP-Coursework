package com.example.ticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TicketingSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(TicketingSystemApplication.class, args);
	}
}