package com.ttn.java.designpatterns;

/**
 *  3. Implement Abstract Factory Pattern to create cars of different categories from different countries.
 */

enum CarType{
    SMALL, SEDAN, LUXURY
}

enum Country{
    INDIA, GERMANY, OTHER
}

abstract class Car {
    private CarType model;
    private Country country;

    abstract void buildCar();

    public Car(CarType model, Country country){
        this.model = model;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Car Model - " + model + " from country - " + country;
    }
}

class SmallCar extends Car{
    @Override
    void buildCar() {
        System.out.println("Building Small Car..");
    }

    public SmallCar(Country country){
        super(CarType.SMALL, country);
        buildCar();
    }
}

class SedanCar extends Car {
    @Override
    void buildCar(){
        System.out.println("Building Sedan Car...");
    }

    public SedanCar(Country country){
        super(CarType.SEDAN, country);
        buildCar();
    }
}

class LuxuryCar extends Car{
    @Override
    void buildCar(){
        System.out.println("Building Luxury Car..");
    }

    public LuxuryCar(Country country){
        super(CarType.LUXURY, country);
        buildCar();
    }
}

class IndiaCarFactory{
    static Car buildCar(CarType model){
        switch (model){
            case SMALL: return (new SmallCar(Country.INDIA));
            case SEDAN: return (new SedanCar(Country.INDIA));
            case LUXURY: return (new LuxuryCar(Country.INDIA));
            default: return null;
        }
    }
}

class GermanyCarFactory{
    static Car buildCar(CarType model){
        switch (model){
            case SMALL: return (new SmallCar(Country.GERMANY));
            case SEDAN: return (new SedanCar(Country.GERMANY));
            case LUXURY: return (new LuxuryCar(Country.GERMANY));
            default: return null;
        }
    }
}


class OtherCarFactory{
    static Car buildCar(CarType model){
        switch (model){
            case SMALL: return (new SmallCar(Country.OTHER));
            case SEDAN: return (new SedanCar(Country.OTHER));
            case LUXURY: return (new LuxuryCar(Country.OTHER));
            default: return null;
        }
    }
}

class CarFactory{
    private CarFactory(){ }

    public static Car buildCar (CarType model, Country country){
        switch (country){
            case INDIA: return IndiaCarFactory.buildCar(model);
            case GERMANY: return GermanyCarFactory.buildCar(model);
            case OTHER: return OtherCarFactory.buildCar(model);
            default: return null;
        }
    }
}

public class Ques3_AbstractFactory {
    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.SEDAN, Country.INDIA) + "\n");
        System.out.println(CarFactory.buildCar(CarType.LUXURY, Country.GERMANY) + "\n");
        System.out.println(CarFactory.buildCar(CarType.SMALL, Country.OTHER) + "\n");
    }
}
