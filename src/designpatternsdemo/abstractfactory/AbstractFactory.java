package designpatternsdemo.abstractfactory;

public interface AbstractFactory {
    Shape createShape(String shape, String color);
}
