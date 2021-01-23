package designpatternsdemo.template;

public class Client {
    public static void main(String[] args) {
        CoffeeTemplate mocha = new Mocha();
        mocha.makeCoffee();
        
        System.out.println("");
        
        CoffeeTemplate americano = new Americano();
        americano.makeCoffee();
    }
}

abstract class CoffeeTemplate{
    public final void makeCoffee(){
        brewCoffee();
        addMilk();
        if (isChocolateRequired())
            addChocolate();
        pourInCup();
    }
    
    public abstract void brewCoffee();
    public abstract void addMilk();
    
    public void addChocolate(){
        System.out.println("Adding chocolate");
    }
    
    public void pourInCup(){
        System.out.println("Pouring into the cup");
    }

    protected boolean isChocolateRequired() {
        return false;
    }
}

class Mocha extends CoffeeTemplate {
    public void brewCoffee() {
        System.out.println("Adding half a cup of Medium "
                + "Strong Coffee brew");
    }
    
    public void addMilk(){
        System.out.println("Adding quater a cup of milk");
    }   

    @Override
    protected boolean isChocolateRequired() {
        return true;
    }   
}

class Americano extends CoffeeTemplate {
    public void brewCoffee() {
        System.out.println("Adding 3/4 of a cup Medium"
                + " Strong Coffee brew");
    }
    
    public void addMilk(){
        //Do nothing
    }
    
}


