package designpatternsdemo.commandpattern;

/**
 * @author TJ
 */
public class Square implements Shape{

    public int scale = 1;
    public String color = "white";
    
    @Override
    public void changeColor(String newColor) {
        color = newColor;
        System.out.println("Square color: " + color);
    }

    @Override
    public void scaleUp() {
        scale++;
        System.out.println("Square scale: " + scale);
    }

    @Override
    public void scaleDown() {
        scale--;
        System.out.println("Square scale: " + scale);   
    }

}
