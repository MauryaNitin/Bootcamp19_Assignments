package com.ttn.java_session_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 10. Design classes having attributes and method(only skeleton) for a coffee shop. There are three different actors in our scenario and i have listed the different actions they do also below
 *
 * * Customer
 *   - Pays the cash to the cashier and places his order, get a token number back
 *   - Waits for the intimation that order for his token is ready
 *   - Upon intimation/notification he collects the coffee and enjoys his drink
 *   ( Assumption:  Customer waits till the coffee is done, he wont timeout and cancel the order. Customer always likes the drink served. Exceptions like he not liking his coffee, he getting wrong coffee are not considered to keep the design simple.)
 *
 * * Cashier
 *   - Takes an order and payment from the customer
 *   - Upon payment, creates an order and places it into the order queue
 *   - Intimates the customer that he has to wait for his token and gives him his token
 *   ( Assumption: Token returned to the customer is the order id. Order queue is unlimited. With a simple modification, we can design for a limited queue size)
 *
 * * Barista
 *  - Gets the next order from the queue
 *  - Prepares the coffee
 *  - Places the coffee in the completed order queue
 *  - Places a notification that order for token is ready
 */

enum Coffee{
    Cappuchino(500), Espresso(600), Latte(750);

    private int price;

    Coffee(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}


class CoffeeShop{
    private static List<Order> pendingOrders = new ArrayList<>();
    private static List<Order> completedOrders = new ArrayList<>();

    public Order getOrder(int OrderId){
        return pendingOrders.get(OrderId);
    }

    public static void addOrder(Order o){
        pendingOrders.add(o);
    }

    public static void completeOrder(Order o){
        if(pendingOrders.remove(o)){
            completedOrders.add(o);
        }
        else{
            System.out.println("Error Occurred!");
        }
    }
    public static Order popOrder(){
        return pendingOrders.remove(0);
    }
}

class Token{
    private static int token = 0;

    public static int setToken(){
       return token++;
    }

    public static void releaseToken(){
        token--;
    }
}


class Order{
    public int order_id;
    public int token;

    private List<Coffee> order_items = new ArrayList<>();

    Order(){
        this.order_id = new Random().nextInt(1000);
        this.token = Token.setToken();
    }

    List<Coffee> getItems(){
        return this.order_items;
    }

    void addItems(Coffee c){
        order_items.add(c);
    }

    void removeItems(Coffee c){
        order_items.remove(c);
    }

    double totalAmount(){
        double GST = 0.17;
        double sum = 0;
        for(Coffee c : this.order_items){
            sum = sum + c.getPrice();
        }
        sum = sum + (sum*GST);
        return sum;
    }

    public int getToken(){
        return token;
    }

}

class Customer{
    private String name;
    private String phn;
    public static int token;
    public static Order o = null;

    Customer(String name, String phn){
        this.name = name;
        this.phn = phn;
    }

    public void placeOrder(List<Coffee> coffees, double amountReceived){
        o = new Order();
        for(Coffee c : coffees){
            o.addItems(c);
        }
        pay(o, amountReceived);
    }

    private void pay(Order o,double amountReceived){
        Cashier.makePayment(o, amountReceived);
    }

    private void enjoy(Order o){
        System.out.println("Customer Enjoying Coffee: ");
        System.out.println(o.getItems());
    }

    public void collectOrder(Order o){
        System.out.println("Your Order is Ready! Please Collect it.");
        Token.releaseToken();
        enjoy(o);
    }
}

class Cashier{
    private String name;
    private int empId;
    private String phn;

    public Cashier(String name, int empId, String phn) {
        this.name = name;
        this.empId = empId;
        this.phn = phn;
    }

    public static void makePayment(Order o,double amountReceived){
        if(o.totalAmount() <= amountReceived){
            CoffeeShop.addOrder(o);
            Customer.token = Token.setToken();
        }
        else{
            System.out.println("Payment Failed!");
        }
    }
}

class Barista{
    private String name;
    private int empId;
    private String phn;
    private static Order next;

    public Barista(String name, int empId, String phn) {
        this.name = name;
        this.empId = empId;
        this.phn = phn;
    }

    private void nextOrder(){
        next = CoffeeShop.popOrder();
        prepare(next);
    }

    private void prepare(Order o){
        System.out.println("Please Wait while we are preparing your Coffee: " + o.getItems() + "for Order id : " + o.order_id);
    }

    private void completeOrder(Order o){
        CoffeeShop.completeOrder(o);
    }
}

public class Ques10_Coffee_shop {
    public static void main(String[] args) {

    }
}
