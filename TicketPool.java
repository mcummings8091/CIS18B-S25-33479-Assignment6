public class TicketPool {
    private int availableTickets;
    private int ticketCount = 0;
    private boolean restock = true;

    public TicketPool(int totalTickets) {
        this.availableTickets = totalTickets;
    }

    public synchronized Ticket reserveTicket(String customerName) { // "Synchronized" only allows one thread at a time, preventing race conditions 
        while (availableTickets == 0 && restock) { // Wait if theres no tickets and theres a restock available
            try {
                System.out.println(customerName + " is waiting for tickets");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(customerName + "Interrupted while waiting.");
                return null;
            }
        }

        if (!restock && availableTickets == 0) {
            return null;
        }

        availableTickets--;
        System.out.println(customerName + " reserved a ticket. Tickets remaining: " + getAvailableTickets());
        return new Ticket(ticketCount++, "Concert");
    }

    public synchronized void addTickets(int count) {
        availableTickets += count;
        System.out.println("Added " + count + " tickets. Total available: " + getAvailableTickets());
        notifyAll(); // Notify waiting threads
        restock  = false;
    }

    public synchronized int getAvailableTickets() {
        return availableTickets;
    }

    public synchronized boolean getRestockStatus() {
        return restock;
    }

    
}