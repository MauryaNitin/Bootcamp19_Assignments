package com.ttn.java.designpatterns;

/**
 * 2. Implement Factory Pattern to get the _Polygon of different type.
 */

interface Polygon {
    int getSides();
}

class Triangle implements Polygon {
    private int sides = 3;
    @Override
    public int getSides() {
        return sides;
    }
}

class Square implements Polygon {
    private int sides = 4;
    @Override
    public int getSides(){
        return sides;
    }
}

class Pentagon implements Polygon {
    private int sides = 5;
    @Override
    public int getSides(){
        return sides;
    }
}

class Hexagon implements Polygon {
    private int sides = 6;
    @Override
    public int getSides(){
        return sides;
    }
}

class PolygonFactory{
    static Polygon getPolygon(String name){
        switch (name.toLowerCase().trim()){
            case "triangle" : return new Triangle();
            case "square" : return new Square();
            case "pentagon" : return new Pentagon();
            case "hexagon" : return new Hexagon();
            default: return null;
        }
    }
}

public class Ques2_Factory {
    public static void main(String[] args) {
        Polygon triangle = PolygonFactory.getPolygon("Triangle");
        System.out.println("Triangle has " + triangle.getSides()  + " sides.");

        Polygon square = PolygonFactory.getPolygon("Square");
        System.out.println("Square has " + square.getSides()  + " sides.");

        Polygon hexagon = PolygonFactory.getPolygon("hexagon");
        System.out.println("Hexagon has " + hexagon.getSides()  + " sides.");
    }
}
