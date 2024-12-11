public class Monitor implements Runnable {
    private TicketPool ticketPool;
    private int interval;
    private volatile boolean running = true; //Flag to control thread

    public Monitor(TicketPool ticketPool, int interval){
        this.ticketPool = ticketPool;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Current ticket pool status: " + ticketPool.getStatus());

            try {
                Thread.sleep(interval * 1000);
            } catch (InterruptedException e ){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    public void stop(){
        running = false;
    }
}

