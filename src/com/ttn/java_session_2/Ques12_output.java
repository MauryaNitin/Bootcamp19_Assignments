package com.ttn.java_session_2;

/*
*
 * 12.What will be the  output on new Child(); ?
 *     class Parent extends Grandparent {
 *
 *         {
 *         System.out.println("instance - parent");
 *         }
 *
 *         public Parent() {
 *         System.out.println("constructor - parent");
 *         }
 *
 *         static {
 *         System.out.println("static - parent");
 *         }
 *     }
 *
 *     class Grandparent {
 *
 *         static {
 *         System.out.println("static - grandparent");
 *         }
 *
 *         {
 *         System.out.println("instance - grandparent");
 *         }
 *
 *         public Grandparent() {
 *         System.out.println("constructor - grandparent");
 *         }
 *     }
 *
 *     class Child extends Parent {
 *
 *         public Child() {
 *         System.out.println("constructor - child");
 *         }
 *
 *         static {
 *         System.out.println("static - child");
 *         }
 *
 *         {
 *         System.out.println("instance - child");
 *         }
 *     }
*/

class Parent extends GrandParent{
    {
        System.out.println("instance - parent");
    }

    public Parent(){
        System.out.println("constructor - parent");
    }
    static {
        System.out.println("static - parent");
    }
}

class GrandParent{
    static {
        System.out.println("static - grandparent");
    }

    {
        System.out.println("instance - grandparent");
    }

    public GrandParent(){
        System.out.println("constructor - grandparent");
    }
}


class Child extends Parent{

    public Child(){
        System.out.println("constructor - child");
    }

    static{
        System.out.println("static - child");
    }

    {
        System.out.println("instance - child");
    }
}


public class Ques12_output {
    public static void main(String[] args) {
        Child c = new Child();
    }
}