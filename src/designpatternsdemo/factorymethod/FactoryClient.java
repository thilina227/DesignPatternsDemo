
package designpatternsdemo.factorymethod;


public class FactoryClient {
    public static void main(String[] args) {
        FactoryInterface factory = new ShapeFactory();
        Shape shape = factory.createShape("square", "green");
        
        shape.draw();


    }
}

//1. abstract product = shape interface
//2. Concrete products = Square and Circle classes
//3. Creator interface = Factory Interface
//4. Concrete creator = ShapeFactory class