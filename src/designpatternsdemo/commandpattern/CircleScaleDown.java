package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class CircleScaleDown implements Command{
    private final Circle circle;

    public CircleScaleDown(Circle circle) {
        this.circle = circle;
    }
        
    @Override
    public void execute() {
        circle.scaleDown();
    }

    @Override
    public void undo() {
        circle.scaleUp();
    }

}
