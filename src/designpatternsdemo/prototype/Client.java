package designpatternsdemo.prototype;

public class Client {
    public static void main(String[] args) {
        Soldier trooper1 = new StormTrooper("Jango Fett", 11111);
        System.out.println(trooper1);
        
        Soldier trooper2 = (Soldier) trooper1.clone();
        
        System.out.println(trooper2);
        
        Soldier robot1 = new RobotSoldier("BattleDroid B1");
        System.out.println(robot1);
        Soldier robot2 = (RobotSoldier) robot1.clone();
        System.out.println(robot2);
    

    }
}


class Weapon{

    public String model = "blaster";
    
}

abstract class Soldier implements Cloneable {
    abstract void display();
    
    @Override
    public Object clone() {
        Object clone = null;

        try {
           clone = super.clone();

        } catch (CloneNotSupportedException e) {
           e.printStackTrace();
        }

        return clone;
    }
    
}

class StormTrooper extends Soldier {

    private String name;
    public int serialNumber;
    public Weapon weapon = new Weapon();

    public StormTrooper(String name, int serial) {
        this.name = name;
        this.serialNumber = serial;
        System.out.println("Generating " + 
                name + " Trooper");
    }

    public void display() {
        System.out.println(name + " Trooper");
    }

    @Override
    public String toString() {
        return "Trooper{" + "name=" + name +
                ", weapon= " + weapon + 
                ", serial= " + serialNumber + "}" +
                " hash:" + this.hashCode();
    }
    
}

class RobotSoldier extends Soldier {

    private String model;

    public RobotSoldier(String model) {
        this.model = model;
        System.out.println("Generating " + model 
                + " RobotSoldier");
    }

    public void display() {
        System.out.println(model + " RobotSoldier");
    }

    @Override
    public String toString() {
        return "RobotSoldier{" + "model=" + model + '}'
                + " hash:" + this.hashCode();
    }
    
}