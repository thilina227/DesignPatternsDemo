package designpatternsdemo.strategy.example2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add( new Item("Soap", 50));
        items.add( new Item("Milk", 250));
        items.add( new Item("Rice", 300));
        Order order1 = new Order(items);
        order1.setDiscount(new VisaDiscount());
        System.out.println("Net Value:" + order1.getNetValue());
        System.out.println("Discounted Value:" + order1.getDiscountedTotal());
        
    }
}

interface Discount{
    double calculate(Order order);
}

class VisaDiscount implements Discount{
    public double calculate(Order order) {
        double total = order.getNetValue();
        return total * 0.9;
    }
}

class DiscountForRice implements Discount{

    @Override
    public double calculate(Order order) {
        for (Item item : order.items) {
            if (item.name.equalsIgnoreCase("rice")){
                item.price = item.price * 0.5;
            }
        }
        return order.getNetValue();
    }
    
}

class FreeShippingStrategy implements Discount{

    @Override
    public double calculate(Order order) {
        return order.getNetValue() - Order.DELIVERY_COST;
    }
    
}

class Order{
    public static final int DELIVERY_COST = 200;
    List<Item> items;
    Discount discount;

    public Order(List<Item> items) {
        this.items = items;
        this.discount = discount;
    }

    
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
    
    public double getNetValue(){
        double total = 0;
        for (Item item : items) {
            total = total + item.price;
        }
        total = total + DELIVERY_COST;
        
        return total;
    }
    
    public double getDiscountedTotal(){
        if (discount == null) {
            return this.getNetValue();
        }
        return discount.calculate(this);
    }
}

class Item {
    String name;
    double price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
}
