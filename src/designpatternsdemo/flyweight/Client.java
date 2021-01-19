package designpatternsdemo.flyweight;

import java.util.HashMap;
import java.util.Random;

public class Client {

    public static void main(String[] args) {
        String colors[] = {"Red", "Black", "Brown", "Blue", "Yellow", "Green", "White"};
        for (int i = 0; i < 10; ++i) {
           Circle circle = (Circle) ShapeFactory.getCircle(colors[new Random().nextInt(colors.length)]);
//            Circle circle = new Circle(colors[new Random().nextInt(colors.length)]);
            circle.display();
        }
    }
}

interface Shape {
    void display();
}

class Circle implements Shape {

    private String color;

    public Circle(String color) {
        this.color = color;
        System.out.println("Generating " + color + " circle");
    }

    public void display() {
        System.out.println(color + " circle");
    }
}

class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
        }
        return circle;
    }
}
