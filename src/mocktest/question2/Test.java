package mocktest.question2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TJ
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new Subject();
        
        Terminal t1 = new Terminal();
        Terminal t2 = new Terminal();
        Terminal t3 = new Terminal();
        
        subject.addObserver(t1);
        subject.addObserver(t2);
        subject.addObserver(t3);
        
        subject.setRate(150);
        subject.setRate(151);
        
    }
}


class Subject{
    private double rate;

    private List<Observer> observers = new ArrayList<>();
    
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
        for (Observer o : observers) {
            o.update(rate);
        }
        
    }
    
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
} 

interface Observer{
    void update(double rate);
}

class Terminal implements Observer{
    public void update(double rate){
        System.out.println("Rate is now " + rate);
    }
}