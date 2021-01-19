package designpatternsdemo.observer;

public class ClientClass {
    public static void main(String[] args) {
       //creating the subject
        TempSubject subject = new TempSubject();
       
       //creating the observers
       DisplayObserver display = new DisplayObserver();
       CoolerObserver cooler = new CoolerObserver();
       
       //registering observers
       subject.registerObserver(display);
       subject.registerObserver(cooler);
       
       //change the temp using the remote
       subject.setTemp(25);
       System.out.println("After an hour");
       
       subject.setTemp(28);
        
    }
}
