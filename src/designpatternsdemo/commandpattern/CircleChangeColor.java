package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class CircleChangeColor implements Command{
    private final Circle circle;
    private final String color;
    private final String previousColor;

    public CircleChangeColor(Circle circle, String color) {
        this.circle = circle;
        this.color = color;
        this.previousColor = circle.color;
    }
            
    @Override
    public void execute() {
        circle.changeColor(color);
    }

    @Override
    public void undo() {
        circle.changeColor(previousColor);
    }

}
