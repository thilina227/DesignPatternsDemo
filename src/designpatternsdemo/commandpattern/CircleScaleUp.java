package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class CircleScaleUp implements Command{
    private final Circle circle;

    public CircleScaleUp(Circle circle) {
        this.circle = circle;
    }
        
    @Override
    public void execute() {
        circle.scaleUp();
        
    }

    @Override
    public void undo() {
        circle.scaleDown();
    }

}
