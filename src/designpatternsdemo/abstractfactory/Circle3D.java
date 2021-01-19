package designpatternsdemo.abstractfactory;

public class Circle3D implements Shape3D{
    private String color;
    private int height;
    
    public Circle3D(String color) {
        this.color = color;
    }    
       
    @Override
    public void draw() {
        System.out.println("drawing a " + this.color + " 3d circle");
    }

    @Override
    public void setColor(String color) {
        this.color  = color;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    
    
}
