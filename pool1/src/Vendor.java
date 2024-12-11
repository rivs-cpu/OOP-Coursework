import java.math.BigDecimal;

public class Vendor implements Runnable {
    private TicketPool ticketPool; // TicketPool which is shared among vendors and customer
    private int totalTickets; //Tickets vendor will to sell
    private int ticketReleaseRate; //Frequency tickets will be added to pool
    private volatile boolean running = true; //Flag to control the thread

    public Vendor(TicketPool ticketPool, int totalTickets, int ticketReleaseRate){
        this.ticketPool = ticketPool;
        this.totalTickets =totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    //Implement the thread
    //Runnable interface should write the implementation for Runnable interface
    @Override
    public void run() {
        for (int i = 1; i <= totalTickets && running; i++) {
            //i is used as ID
            Ticket ticket = new Ticket(i, "Event Simple", new BigDecimal("1000"));
            ticketPool.addTickets(ticket);

            //The ticket release frequency means the delay
            try {
                Thread.sleep(ticketReleaseRate * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    public void stop() {
        running = false;
    }
}
