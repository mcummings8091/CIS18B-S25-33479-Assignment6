public class TicketRestocker implements Runnable {
    private TicketPool ticketPool;
    private int ticketsToAdd;
    private long sleepDelayMilli;

    public TicketRestocker(TicketPool ticketPool, int ticketsToAdd, long sleepDelayMilli) {
        this.ticketPool = ticketPool;
        this.ticketsToAdd = ticketsToAdd;
        this.sleepDelayMilli = sleepDelayMilli;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepDelayMilli);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ticketPool.addTickets(ticketsToAdd);
    }
}