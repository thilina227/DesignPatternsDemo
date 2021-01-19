package designpatternsdemo.observer;

import java.util.ArrayList;
import java.util.List;

public class TempSubject implements Subject {
    private int temp;
    private List<Observer> observers = new ArrayList<>();

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(this.temp);
        }
    }
    
    
}
