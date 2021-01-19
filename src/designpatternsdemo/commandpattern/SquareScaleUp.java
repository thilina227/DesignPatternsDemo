package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class SquareScaleUp implements Command{
    private final Square squre;

    public SquareScaleUp(Square squre) {
        this.squre = squre;
    }
        
    @Override
    public void execute() {
        squre.scaleUp();
    }

    @Override
    public void undo() {
        squre.scaleDown();
    }

}
