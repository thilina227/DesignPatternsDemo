package designpatternsdemo.facade;

public class SeatBooking {

    Flight flight = new Flight();
    
    public boolean bookSeat(String seatClass, String preference) {
        if (seatClass.equals("bueinss")) {
            int availability = flight.getBusinessSeats().get(preference);
            if (availability > 0) {
                flight.getBusinessSeats().put(preference, availability - 1);
                return true;
            } else {
                return false;
            }
        } else if(seatClass.equals("economy")) {
            int availability = flight.getEconomySeats().get(preference);
            if (availability > 0) {
                flight.getEconomySeats().put(preference, availability - 1);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
}
