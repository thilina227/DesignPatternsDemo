package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class Client {
    public static void main(String[] args) {
        ToolBox toolbox = new ToolBox();
        
        Square square = new Square();
        Circle circle = new Circle();
        
        toolbox.changeCircleColor(circle, "red");
        toolbox.scaleUpCircle(circle);
        toolbox.scaleUpCircle(circle);
        toolbox.scaleUpCircle(circle);
        
        System.out.println("Starting undoing");
        toolbox.undo();
        toolbox.undo();
        toolbox.undo();
        toolbox.undo();
        
    }
}
