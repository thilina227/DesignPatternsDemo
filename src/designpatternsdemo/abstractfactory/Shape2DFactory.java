
package designpatternsdemo.abstractfactory;



public class Shape2DFactory implements AbstractFactory{
    
    public Shape createShape(String shape, String color) {
        Shape newShape = null;
        
        if (shape.equalsIgnoreCase("square")) {
            newShape = new Square(color);
        } else if (shape.equalsIgnoreCase("circle")) {
            newShape = new Circle(color);
        } 
        return newShape;
    }
}
