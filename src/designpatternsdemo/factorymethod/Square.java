
package designpatternsdemo.factorymethod;

public class Square implements Shape {
    private String color;

    public Square(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("drawing " + this.color + " Square");
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
