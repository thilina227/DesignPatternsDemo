package designpatternsdemo.observer;

public class DisplayObserver implements Observer {

    @Override
    public void update(int temp) {
        System.out.println("Display: "  + temp);
    }
    
}
