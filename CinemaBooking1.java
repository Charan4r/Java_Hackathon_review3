class CinemaBooking {
    private String customerName;
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private String bookingStatus;
    private double totalAmount;
    private double discount;
    private double finalAmount;

    
    CinemaBooking(String customerName, String movieName) {
        this(customerName, movieName, 240.0);
    }

    
    CinemaBooking(String customerName, String movieName, double ticketPrice) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.bookingStatus = "Not Booked";
    }

    
    CinemaBooking(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        this(customerName, movieName, ticketPrice);
        bookTickets(numberOfTickets);
    }

    
    void bookTickets(int tickets) {
        if (tickets <= 0) {
            numberOfTickets = 0;
            totalAmount = 0;
            discount = 0;
            finalAmount = 0;
            bookingStatus = "Booking Failed - Invalid number of tickets";
            return;
        }
        numberOfTickets = tickets;
        totalAmount = ticketPrice * tickets;
        discount = (tickets >= 5) ? totalAmount * 0.10 : 0;   
        finalAmount = totalAmount - discount;
        bookingStatus = "Booking Successful";
    }

    
    void bookTickets(int tickets, double price) {
        this.ticketPrice = price;
        bookTickets(tickets);
    }

    
    boolean isSameCustomer(CinemaBooking other) {
        return this.customerName.equalsIgnoreCase(other.customerName);
    }

    
    void displaySummary() {
        System.out.println("========== CINEMA TICKET BOOKING ==========");
        System.out.println();
        System.out.println("Customer Name   : " + customerName.toUpperCase());
        System.out.println("Movie Name      : " + movieName.toUpperCase());
        System.out.println("Ticket Price    : Rs. " + String.format("%.2f", ticketPrice));
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Booking Status  : " + bookingStatus);
        System.out.println("Total Amount    : Rs. " + String.format("%.2f", totalAmount));
        System.out.println("Discount        : Rs. " + String.format("%.2f", discount));
        System.out.println("Final Amount    : Rs. " + String.format("%.2f", finalAmount));
        System.out.println();
    }
}

public class CinemaBooking1{
    public static void main(String[] args) {
        CinemaBooking b1 = new CinemaBooking("Sneha", "Avatar", 200, 5);

        
        CinemaBooking b2 = new CinemaBooking("Arjun", "Avatar");
        b2.bookTickets(2, 200);

        
        CinemaBooking b3 = new CinemaBooking("sneha", "Avatar", 200);
        b3.bookTickets(0);

        b1.displaySummary();
        b2.displaySummary();
        b3.displaySummary();

        
        System.out.println("Booking 1 and 2 same customer? " + b1.isSameCustomer(b2));
        System.out.println("Booking 1 and 3 same customer? " + b1.isSameCustomer(b3));
    }
}