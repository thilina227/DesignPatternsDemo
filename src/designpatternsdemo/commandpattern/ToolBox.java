package designpatternsdemo.commandpattern;

import java.util.Stack;

/**
 * @author TJ
 */
public class ToolBox {
    
    private Stack<Command> stack = new Stack();
    
    public void scaleUpCircle(Circle cicle) {
        CircleScaleUp scaleUp = new CircleScaleUp(cicle);
        scaleUp.execute();
        stack.add(scaleUp);
    }
    
    public void scaleDownCircle(Circle circle) {
       CircleScaleDown scaleDown = new CircleScaleDown(circle);
       scaleDown.execute();
       stack.add(scaleDown);
    }
    
    public void changeCircleColor(Circle circle, String color) {
        CircleChangeColor changeColor = new CircleChangeColor(circle, color);
        changeColor.execute();
        stack.add(changeColor);
    }
    
     public void scaleUpSquare(Square square) {
        SquareScaleUp scaleUp = new SquareScaleUp(square);
        scaleUp.execute();
        stack.add(scaleUp);
    }
    
    public void scaleDownSquare(Square square) {
       SquareScaleDown scaleDown = new SquareScaleDown(square);
       scaleDown.execute();
       stack.add(scaleDown);
    }
    
    public void changeCircleSquarer(Square square, String color) {
        SquareChangeColor changeColor = new SquareChangeColor(square, color);
        changeColor.execute();
        stack.add(changeColor);
    }
    
    public void undo(){
        if (!stack.empty()) {
            Command command = stack.pop();
            command.undo();
        }
    }
}
