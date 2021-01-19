package designpatternsdemo.adapter;


public class FishMammalAdapter implements Mammal {
    private Fish fish;

    public FishMammalAdapter(Fish fish) {
        this.fish = fish;
    }
    
    @Override
    public void run() {
        this.fish.swim();
    }
}
