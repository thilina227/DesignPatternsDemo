package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class SquareScaleDown implements Command{
    private final Square squre;

    public SquareScaleDown(Square squre) {
        this.squre = squre;
    }
        
    @Override
    public void execute() {
        squre.scaleDown();
    }

    @Override
    public void undo() {
        squre.scaleUp();
    }

}
