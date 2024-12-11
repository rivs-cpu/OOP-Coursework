import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Thread> vendorThreads = new ArrayList<>();
    private static List<Thread> customerThreads = new ArrayList<>();
    private static List<Vendor> vendors = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static Thread monitorThread;
    private static Monitor monitor;

    public static void main (String[] args) {
        //system configuration to handle user inputs
        SystemConfiguration config = new SystemConfiguration();
        config.configureSystem();

        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity()); //The TicketPool which is shared among vendors and customers

        //vendor and customer objects
        for (int i = 0; i < 10; i++) {
            Vendor vendor = new Vendor(ticketPool, config.getTotalTickets(), config.getTicketReleaseRate());
            vendors.add(vendor);
            Thread vendorThread = new Thread(vendor, "Vendor" + i);
            vendorThreads.add(vendorThread);

            Customer customer = new Customer(ticketPool, config.getCustomerRetrievalRate(), 5);
            customers.add(customer);
            Thread customerThread = new Thread(customer, "Customer" + i);
            customerThreads.add(customerThread);
        }
        //Create and start the monitor thread
        monitor = new Monitor(ticketPool, 5); //Monitor interval
        monitorThread = new Thread(monitor, "Monitor");
        monitorThread.start();

        //Start the threads
        startThreads();

        //wait for user input to stop the threads
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to stop the threads...");
        scanner.nextLine();

        //Stop Threads
        stopThreads();
    }
    private static void startThreads(){
        for (Thread vendorThread : vendorThreads) {
            vendorThread.start();
        }
        for (Thread customerThread : customerThreads){
            customerThread.start();
        }
    }
    private static void stopThreads(){
        for (Vendor vendor : vendors) {
            vendor.stop();
        }
        for (Customer customer : customers) {
            customer.stop();
        }
        for (Thread vendorThread : vendorThreads){
            try {
                vendorThread.join();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        for (Thread customerThread : customerThreads){
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        //stop the monitor thread
        monitor.stop();
        try {
            monitorThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All threads have been Stopped.");
    }
}
