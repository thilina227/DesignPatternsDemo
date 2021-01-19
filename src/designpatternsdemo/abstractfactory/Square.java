
package designpatternsdemo.abstractfactory;


public class Square implements Shape2D {
    private String color;

    public Square(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("drawing " + this.color + " 2d Square");
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }
    
    
}
