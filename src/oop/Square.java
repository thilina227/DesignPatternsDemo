package oop;

public class Square {
    private int squareSide;
    private String color;
    
    public Square(int squareSide, String color) {
        this.squareSide = squareSide;
        this.color = color;
    }
    
    public void draw() {
        System.out.println(this.color + " Square with side = " + squareSide);
    }

    public void setSquareSide(int side) {
        if (side > 0) {
            this.squareSide = side;
        }
    }
    
    public int getSquareSide() {
        return this.squareSide;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equalsIgnoreCase("RED") || color.equalsIgnoreCase("BLUE")) {
            this.color = color;
        } else {
            System.out.println("Invalid color :" + color);
        }                
    }
    
    
    
}