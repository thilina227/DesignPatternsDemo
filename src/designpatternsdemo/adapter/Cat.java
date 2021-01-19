
package designpatternsdemo.adapter;

public class Cat implements Mammal{
    @Override
    public void run() {
        System.out.println("Cat runs");
    }
}
