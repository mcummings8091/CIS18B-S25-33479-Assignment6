import java.util.concurrent.*;

public class ReservationTest {
    public static void main(String args[]) {
        TicketPool pool = new TicketPool(2);
        TicketRestocker ticketRestocker = new TicketRestocker(pool, 2, 3000);
         
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(new Customer("Nathan", pool));
            executor.submit(new Customer("Troy", pool));
            executor.submit(new Customer("Todd", pool));
            executor.submit(new Customer("Tia", pool));
            executor.submit(new Customer("Vip", pool));
            executor.submit(new Customer("Vap", pool));

            executor.submit(ticketRestocker);
        }

    }
}