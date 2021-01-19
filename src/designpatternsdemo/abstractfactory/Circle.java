
package designpatternsdemo.abstractfactory;

public class Circle implements Shape2D {
    private String color;
    
    public Circle(String color) {
        this.color = color;
    }    
       
    @Override
    public void draw() {
        System.out.println("drawing a " + this.color + " 2d circle");
    }

    @Override
    public void setColor(String color) {
        this.color  = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
       
}
