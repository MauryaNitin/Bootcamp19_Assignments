package com.ttn.ex_1;

/**
 * Q9.Write a program to display values of enums using a constructor & getPrice() method (Example display house & their prices)
 *
 * */

enum House {
    BHK_1(2000000),
    BHK_2(4000000),
    BHK_3(8000000);

    private int price;

    House (int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

}

public class ques9_Enum {
    public static void main(String[] args) {
        House h1 = House.BHK_1;
        House h2 = House.BHK_2;
        House h3 = House.BHK_3;

        System.out.println("1-BHK = " + h1.getPrice());
        System.out.println("2-BHK = " + h2.getPrice());
        System.out.println("3-BHK = " + h3.getPrice());
    }
}
