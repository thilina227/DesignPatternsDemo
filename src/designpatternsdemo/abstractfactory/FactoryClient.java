
package designpatternsdemo.abstractfactory;


public class FactoryClient {
    public static void main(String[] args) {
        AbstractFactory factory = new Shape3DFactory();
        Shape shape = factory.createShape("circle", "RED");
        shape.draw();
        
        AbstractFactory factory2d = new Shape2DFactory();
        Shape square2d = factory2d.createShape("square", "blue");
        square2d.draw();
        
    }
}
