package designpatternsdemo.facade.example2;


public class Client {
    public static void main(String[] args) {
        WashingMachineFacade washingMachine = new WashingMachineFacade();
        washingMachine.dryCloths();
    }
}
