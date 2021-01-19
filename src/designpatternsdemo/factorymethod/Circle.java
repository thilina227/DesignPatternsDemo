
package designpatternsdemo.factorymethod;


public class Circle implements Shape {
    private String color;
    
    public Circle(String color) {
        this.color = color;
    }    
       
    @Override
    public void draw() {
        System.out.println("drawing a " + this.color + " circle");
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
