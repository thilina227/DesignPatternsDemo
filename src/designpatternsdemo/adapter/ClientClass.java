
package designpatternsdemo.adapter;


public class ClientClass {
    public static void useMammal(Mammal mammal){
        mammal.run();
    }
    
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        
        GoldFish goldFish = new GoldFish();
        FishMammalAdapter fishAdapter = new FishMammalAdapter(goldFish);
        
        useMammal(dog);
        useMammal(cat);
        useMammal(fishAdapter);
    }
}
