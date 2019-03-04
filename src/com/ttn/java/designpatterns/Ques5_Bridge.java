package com.ttn.java.designpatterns;

/**
 * 5. Implement Bridge Design Pattern for Color and _Polygon such that _Polygon and Color can be combined together
 * e.g BlueSquare, RedSquare, PinkTriangle etc.
 */

interface Color {
    String fillColor();
}

class Red implements Color {
    @Override
    public String fillColor() {
        return "Red";
    }
}

class Blue implements Color {
    @Override
    public String fillColor() {
        return "Blue";
    }
}

class Green implements Color {
    @Override
    public String fillColor() {
        return "Green";
    }
}

abstract class _Polygon {
    private Color color;

    abstract void display();

    _Polygon(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return " -> color=" + color.fillColor();
    }
}

class _Triangle extends _Polygon {
    private int sides = 3;

    @Override
    public void display() {
        System.out.println(this);
    }

    public _Triangle(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Triangle {" +
                " sides=" + sides + super.toString() + " } ";
    }
}

class _Square extends _Polygon {
    private int sides = 4;

    @Override
    public void display() {
        System.out.println(this);
    }

    public _Square(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Square {" +
                " sides=" + sides + super.toString() + " } ";
    }
}


public class Ques5_Bridge {
    public static void main(String[] args) {
        _Polygon blueSquare = new _Square(new Blue());
        _Polygon greenTriangle = new _Triangle(new Green());

        blueSquare.display();
        greenTriangle.display();
    }
}
