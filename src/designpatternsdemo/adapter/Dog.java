package designpatternsdemo.adapter;


public class Dog implements Mammal {
    @Override
    public void run() {
        System.out.println("Dog runs");
    }
}
