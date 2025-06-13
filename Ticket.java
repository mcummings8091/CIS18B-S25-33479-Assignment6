public class Ticket {
    private final int id;
    private final String event;

    public Ticket(int id, String event) {
        this.id = id;
        this.event = event;
    }

    public int getId() { return id; }
    public String getEvent() { return event; }
}