
package designpatternsdemo.factorymethod.badexample;


public class BadFactoryExample {
    public static void main(String[] args) {
        //Shape is going to receive from the user selection
        Shape shape = new Square(4);
        
        
        if (shape instanceof Circle) {
            drawCircle((Circle) shape);
        } else if (shape instanceof Square) {
            drawSquare((Square) shape);
        }
        
        if (shape instanceof Circle) {
            //todo calculate cirle area
        }
    }
    
    public static void drawCircle(Circle circle) {
        circle.drawCirlc();
    }
    
    public static void drawSquare(Square square) {
        square.drawSquare();
    }
}

interface Shape {
    
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    
    public void drawCirlc() {
        System.out.println("drawing a cirle");
    }
}

class Square implements Shape{
    private int side;
    
    public Square(int side) {
        this.side = side;
    }
    
    public void drawSquare() {
        System.out.println("drawing a square");
    }
}
