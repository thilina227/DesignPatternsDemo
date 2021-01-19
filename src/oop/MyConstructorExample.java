package oop;

public class MyConstructorExample {
    public static void main(String[] args) {
        Square redSquare = new Square(5, "RED");
        
        redSquare.draw();
    }
}

//CONSTRUCTORS


interface VoiceMessage{
    void dial(String phoneNumber);
    void playVoiceMessage(String message);
    void disconnect();
}

