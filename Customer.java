

public class Customer implements Runnable {
    private String name;
    private TicketPool ticketpool;

    public Customer(String name, TicketPool ticketpool) {
        this.name = name;
        this.ticketpool = ticketpool;
    }

    @Override
    public void run() {
        // will finish
        Ticket ticket = ticketpool.reserveTicket(name);
        if (ticket != null) {
            System.out.println(name + " got a ticket#: " + ticket.getId() + "! for : " + ticket.getEvent());
        } else {
            System.out.println(name + " did not get a ticket... Better luck next time!");
        }
    }
}