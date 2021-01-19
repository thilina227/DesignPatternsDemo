package designpatternsdemo.observer;

public class CoolerObserver implements Observer {
    private int roomTemp = 27;
    
    @Override
    public void update(int temp) {
        if (roomTemp <= temp) {
            System.out.println("decrease cooling");
        } else {
            System.out.println("increase cooling");
        }
    }
    
}
