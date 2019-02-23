package com.ttn.java_session_2;

/**
 * 4. WAP to create singleton class.
 */

class Singleton_example{

    private static Singleton_example se ;

    static {
        se = null;
    }

    private Singleton_example(){}

    public static Singleton_example getInstance(){
        if(se == null){
            se = new Singleton_example();
        }
        return se;
    }
}

public class Ques4_Singleton {
    public static void main(String[] args) {
        Singleton_example obj1 = Singleton_example.getInstance();
        Singleton_example obj2 = Singleton_example.getInstance();
        Singleton_example obj3 = Singleton_example.getInstance();
        System.out.println("Is obj1 is equal to obj2 : " + (obj1 == obj2));
        System.out.println("Is obj2 is equal to obj3 : " + (obj2 == obj3));

    }
}
