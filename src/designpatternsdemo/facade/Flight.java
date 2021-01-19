package designpatternsdemo.facade;

import java.util.HashMap;
import java.util.Map;


public class Flight {
    
    private static Map<String, Integer> economySeats = new HashMap<>();
    private static Map<String, Integer> businessSeats = new HashMap<>();

    
    public Flight() {
        economySeats.put("window", 2);
        economySeats.put("isle", 2);
        businessSeats.put("window", 2);
        businessSeats.put("isle", 2);
    }

    public Map<String, Integer> getEconomySeats() {
        return economySeats;
    }

    public Map<String, Integer> getBusinessSeats() {
        return businessSeats;
    }
    
}
