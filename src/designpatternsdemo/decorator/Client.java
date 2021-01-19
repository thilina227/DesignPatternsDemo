package designpatternsdemo.decorator;

public class Client {
    public static void main(String[] args) {
        Car car = new BodyKit(new AlloyWheels(new BmwM3()));
        System.out.println(car.getCost());
    }
}

interface Car {
    double getCost();
}

class BmwM3 implements Car{
    @Override
    public double getCost() {
        //some more complex code here
        return 5000;
    }   
}


abstract class CarDecorator implements Car{
    protected Car decoratedCar;
    
    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }
    
    public double getCost(){
        return decoratedCar.getCost();
    }
}

class SportsSpoiler extends CarDecorator{
    public SportsSpoiler(Car car) {
        super(car);
        System.out.println("Adding spoiler cost");
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 200;
    }
}

class AlloyWheels extends CarDecorator{

    public AlloyWheels(Car car) {
        super(car);
        System.out.println("Adding Alloy Wheels cost");
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 500;
    }
}


class BodyKit extends CarDecorator{

    public BodyKit(Car car) {
        super(car);
        System.out.println("Adding Body Kit cost");
    }
    
    @Override
    public double getCost() {
        return super.getCost() + 800;
    }
}


