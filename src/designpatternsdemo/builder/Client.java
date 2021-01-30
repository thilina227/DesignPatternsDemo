package designpatternsdemo.builder;

public class Client {
    public static void main(String[] args) {
        MealBuilder builder = new BurgerMealBuilder();
        
        MealProduct meal = builder.addBurger(new VegeBurger()).addChips(new PotatoChips(1)).addSoda(new Pepsi()).build();
        //                         |----------------------------------requirements-----------------------------|--actual building
        
       
    }
}


interface MealBuilder {
    MealBuilder addBurger(Burger burger);
    MealBuilder addSoda(Soda soda);
    MealBuilder addChips(Chips chips);
    MealProduct build();
}

class BurgerMealBuilder implements MealBuilder{
    private Burger burger;
    private Soda soda;
    private Chips chips;
    
    @Override
    public MealBuilder addBurger(Burger burger) {
        this.burger = burger;
        return this;
    }

    @Override
    public MealBuilder addSoda(Soda soda) {
        this.soda = soda;
        return this;
    }

    @Override
    public MealBuilder addChips(Chips chips) {
        this.chips = chips;
        return this;
    }

    @Override
    public MealProduct build() {
        MealProduct meal = new MealProduct();
        meal.setBurger(burger);
        meal.setChips(chips);
        meal.setSoda(soda);
        return meal;
    }
}




class MealProduct {
    private Burger burger;
    private Soda soda;
    private Chips chips;

    public Burger getBurger() {
        return burger;
    }

    public void setBurger(Burger burger) {
        this.burger = burger;
    }

    public Soda getSoda() {
        return soda;
    }

    public void setSoda(Soda soda) {
        this.soda = soda;
    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }
}

interface Burger{
    String getBurgerType();
}

interface Soda {
    String getSodaType();
}

interface Chips{

}


class Coke implements Soda{
    @Override
    public String getSodaType(){
        return "Coke";
    }
}

class Pepsi implements Soda{
    @Override
    public String getSodaType(){
        return "Pepsi";
    }
}


class PotatoChips implements Chips {
    private int size = 2;

    public PotatoChips(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}


class VegeBurger implements Burger{
    private String burgerType = "VegeBurger";

    @Override
    public String getBurgerType() {
        return burgerType;
    }    
}

class ChickenBurger implements Burger{
    private String burgerType = "ChickenBurger";

    @Override
    public String getBurgerType() {
        return burgerType;
    }    
}


