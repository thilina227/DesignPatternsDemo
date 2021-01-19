
package designpatternsdemo.abstractfactory;



public class Shape3DFactory implements AbstractFactory{
    
    public Shape createShape(String shape, String color) {
        Shape newShape = null;
        
        if (shape.equalsIgnoreCase("circle")) {
            newShape = new Circle3D(color);
        } 
        return newShape;
    }
}
