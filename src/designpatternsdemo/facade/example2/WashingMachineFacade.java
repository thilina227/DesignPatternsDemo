package designpatternsdemo.facade.example2;

public class WashingMachineFacade {
    private Washing washing = new Washing();
    private Rinsing rinsing = new Rinsing();
    private Spinning spinning = new Spinning();
    private Drying drying = new Drying();
    
    public void washCloths(){
        washing.wash();
        rinsing.rinse();
        spinning.spin();
        drying.dry();
    }
    
    public void dryCloths() {
        spinning.spin();
        drying.dry();
    }
    
}
