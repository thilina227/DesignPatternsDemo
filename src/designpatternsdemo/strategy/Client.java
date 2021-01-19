package designpatternsdemo.strategy;

public class Client {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.id();
        duck.fly();
        duck.quack();
       
    }
}

abstract class Duck{
    protected FlyStrategy flyStrategy;
    protected QuackStrategy quackStrategy;
    
    public void fly() {
        flyStrategy.fly();
    }
    public void quack(){
        quackStrategy.quack();
    }
    public abstract void id();
}

class MallardDuck extends Duck{

    public MallardDuck() {
        this.flyStrategy = new FlyWithWings();
        this.quackStrategy = new Quack();
    }

    @Override
    public void id() {
        System.out.println("Mallard Duck");
    }
}


class RedHeadDuck extends Duck{

    public RedHeadDuck() {
        this.flyStrategy = new NoFly();
        this.quackStrategy = new Quack();
    }
    
    public void id(){
        System.out.println("ReadHead duck");
    }
}

class RubberDuck extends Duck{
   
    public RubberDuck() {
        this.flyStrategy = new NoFly();
        this.quackStrategy = new Squeak();
    }
    
   
    public void id() {
        System.out.println("Rubber duck");
    }
}

class RobotDuck extends Duck{
   
    public RobotDuck() {
        this.flyStrategy = new FlyWithRockets();
        this.quackStrategy = new Quack();
    }
    
    public void id() {
        System.out.println("Robot duck");
    }
}

interface FlyStrategy {
    void fly();
}

class FlyWithWings implements FlyStrategy {
    public void fly(){
        System.out.println("Fly with wings");
    }
}

class NoFly implements FlyStrategy {
    public void fly(){
        System.out.println("Can't fly");
    }
}

class FlyWithRockets  implements FlyStrategy {
    public void fly(){
        System.out.println("Flying with rockets");
    }
}

interface QuackStrategy{
    void quack();
}

class Quack implements QuackStrategy {
    public void quack(){
        System.out.println("Quack!");
    }
}

class Squeak implements QuackStrategy{
    public void quack(){
        System.out.println("Squeak!");
    }
}


