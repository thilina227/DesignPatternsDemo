package designpatternsdemo.facade;

//This is a facade for the flight reservation
public class FlightReservation {
    SeatBooking booking = new SeatBooking();
    Meal meal = new Meal();
    
    public void reserveFlight(String seatClass, String preference, String mealPreference) {
        if (booking.bookSeat(seatClass, preference)) {
            System.out.println("Booked successfully");
            meal.addMealPreference(mealPreference);
        } else {
            System.out.println("Seat not available");
        }
    }
    
    
}
