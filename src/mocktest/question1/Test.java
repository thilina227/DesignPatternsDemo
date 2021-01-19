package mocktest.question1;


public class Test {
    public static void main(String[] args) {
        RemoteControlFacade remote = new RemoteControlFacade();
        remote.goForward();
        remote.stop();
        remote.reverse();
        remote.stop();
    }
}

//Applying facade pattern

interface Facade{
    void goForward();
    void reverse();
    void stop();
}

class RemoteControlFacade implements Facade {

    private Ignition ignition;
    private Brake brake;
    private Accelerate accelerate;
    private Transmission transmission;

    public RemoteControlFacade() {
        ignition = new Ignition();
        brake = new Brake();
        accelerate = new Accelerate();
        transmission = new Transmission();
    }
      
    
    @Override
    public void goForward() {
        System.out.println("-------Going forward");
        
//        Start ignition
        ignition.switchOn();
//        Shift to Drive
        transmission.shiftToDrive();
//        Release brake
        brake.release();
//        Accelerate up
        accelerate.speedUp();
    }

    @Override
    public void reverse() {
        System.out.println("-------Going Backwards");
        //Start ignition
        ignition.switchOn();
//        Release brake
        brake.release();
//        Shift to Reverse
        transmission.shiftToReverse();
//        Accelerate up
        accelerate.speedUp();

    }

    @Override
    public void stop() {
        System.out.println("-------Stopping");
        
        accelerate.slowDown();
//        Apply brakes
        brake.apply();
//        Shift to parking
        transmission.shitParking();
//        Stop ignition
        ignition.switchOff();
    }
}

class Ignition {
    void switchOn(){
        System.out.println("Switch on");
    }
    
    void switchOff(){
        System.out.println("Switch off");
    }
}

class Brake{
    void apply(){
        System.out.println("Apply brake");
    }
    
    void release (){
        System.out.println("Release brake");
    }
}


class Accelerate{
    void speedUp(){
        System.out.println("Accellerate up");
    }
    
    void slowDown(){
        System.out.println("Accellerate down");
    }
}

class Transmission{
    void shitParking(){
        System.out.println("shift to Parking");
    }
    
    void shiftToDrive(){
        System.out.println("shift to drive");
    }
       
    void shiftToReverse(){
        System.out.println("Shift to Reverse");
    }
}



