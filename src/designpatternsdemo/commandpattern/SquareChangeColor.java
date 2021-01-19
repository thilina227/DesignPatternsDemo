package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class SquareChangeColor implements Command{
    private final Square square;
    private final String color;
    private final String previousColor;

    public SquareChangeColor(Square square, String color) {
        this.square = square;
        this.color = color;
        this.previousColor = square.color;
    }
            
    @Override
    public void execute() {
        square.changeColor(color);
    }

    @Override
    public void undo() {
        square.changeColor(previousColor);
    }

}
