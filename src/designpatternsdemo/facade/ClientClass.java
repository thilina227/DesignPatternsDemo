package designpatternsdemo.facade;

/*
Imagine the below scenario
A client is placing a booking for flight to UK from the new Airline "Spark Air".
Let's assume client picks one of the flights on this Sunday.

In order to book the flight, it requires various subsystems to check the availability of.
    1. Class - (Business class or economy) 
    2. The seat (Window seat, isle or middle)
    3. Meal preference (Vegetarial/Non-vege)

*/
public class ClientClass {
    FlightReservation reservation = new FlightReservation();
    
    public void bookSeat(String seatClass, String preference, String mealPreference) {
       reservation.reserveFlight(seatClass, preference, mealPreference);
    }
    
    public static void main(String[] args) {
        ClientClass client = new ClientClass();
        client.bookSeat("economy", "window", "vegetarian");
        client.bookSeat("economy", "window", "vegetarian");
        client.bookSeat("economy", "isle", "vegetarian");
        
    }
}