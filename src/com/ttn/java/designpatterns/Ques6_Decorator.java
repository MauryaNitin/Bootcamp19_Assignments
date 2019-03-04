package com.ttn.java.designpatterns;

/**
 * 6. Implement Decorator pattern to decorate the Pizza with toppings.
 */

interface Pizza {
    String addTopping();
}

class NormalPizza implements Pizza {
    @Override
    public String addTopping(){
        return ("Normal Pizza");
    }
}

abstract class SpecialPizza implements Pizza {
    private Pizza pizza;

    SpecialPizza(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String addTopping(){
        return pizza.addTopping();
    }
}

class OnionTopping extends SpecialPizza{
    public OnionTopping(Pizza pizza){
        super(pizza);
    }

    @Override
    public String addTopping() {
        return (super.addTopping() + addOnionsTopping());
    }

    private String addOnionsTopping(){
        return " with onions";
    }
}

class CapsicumTopping extends SpecialPizza{
    public CapsicumTopping(Pizza pizza){
        super(pizza);
    }

    @Override
    public String addTopping() {
        return super.addTopping() + addCapsicumTopping();
    }

    private String addCapsicumTopping(){
        return " with capsicums";
    }
}

class TomatoTopping extends SpecialPizza{
    public TomatoTopping(Pizza pizza){
        super(pizza);
    }

    @Override
    public String addTopping() {
        return super.addTopping() + addTomatoTopping();
    }

    private String addTomatoTopping(){
        return " with tomato";
    }
}

class CornTopping extends SpecialPizza{
    public CornTopping(Pizza pizza){
        super(pizza);
    }

    @Override
    public String addTopping() {
        return super.addTopping() + addCornTopping();
    }

    private String addCornTopping(){
        return " with Golden Corn";
    }
}


public class Ques6_Decorator {
    public static void main(String[] args) {
        Pizza p = new OnionTopping(new CapsicumTopping(new TomatoTopping(new OnionTopping(new NormalPizza()))));
        System.out.println(p.addTopping());
    }
}
