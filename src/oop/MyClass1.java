package oop;

//TODO
// class
// Iterface
// Abstract class


public class MyClass1 {
    public static void main(String[] args) {
        Snail snail = new Snail();
        makeAnimalSound(snail);
        snail.eat();
    }
    
    public static void makeAnimalSound(Animal animal) {
        animal.makeSound();
    }
    
}

abstract class Animal {
    void makeSound() {
        System.out.println("This is the default sound of an animal. No sound");
    }
    
    abstract void eat();
    
}

abstract class Mamal extends Animal{
    
    int countMyLegs() {
        return 4;
    }

}


class Cat extends Mamal {
    
    public void makeSound() {
        System.out.println("Meow");
    }
    
    public void eat() {
        System.out.println("Cat eats mouse");
    }
    
}

class Dog extends Mamal {
    public void makeSound(){
        System.out.println("Woof");
    }

    @Override
    void eat() {
        System.out.println("Dog eats meat");
    }
}

class Bird extends Animal {
    
    public void makeSound() {
        System.out.println("Chirp");
    }

    @Override
    void eat() {
        System.out.println("Birds eat fruit");
    }

  

}

class Snail extends Animal{
    public void eat() {
        System.out.println("I'm eating plants");
    }
}