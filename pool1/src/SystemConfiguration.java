import java.util.Scanner;

public class SystemConfiguration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public void configureSystem() { //user to enter the system parameter and checks the input
        Scanner scanner = new Scanner (System.in);

        this.totalTickets = getValidIntInput (scanner, "Enter total number of tickets: ");
        this.ticketReleaseRate =  getValidIntInput (scanner, "Enter ticket release rate (in seconds): ");
        this.customerRetrievalRate = getValidIntInput (scanner, "Enter customer Retrieval rate (in seconds): ");
        this.maxTicketCapacity = getValidIntInput (scanner, "Enter maximum ticket capacity: ");

        System.out.println("Configuration Complete!");
        System.out.println("Total Tickets: " + totalTickets);
        System.out.println("Ticket Release Rate: " + ticketReleaseRate);
        System.out.println("Customer Retrieval Rate: " + customerRetrievalRate);
        System.out.println("Max Ticket Capacity: " + maxTicketCapacity);
    }

    /**
     * Helper method to get and check user input.
     * @param scanner Scanner object for reading user input
     * @param prompt prompt The message to show to the user
     * @return A valid integer input from the user
     */

    private int getValidIntInput(Scanner scanner, String prompt){
        int value;
        while (true) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Please Enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number");
                scanner.next(); //Clear the invalid input
            }
        }
        return value;
    }
    //Getters for the configuration parameters

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }
}
