package com.ttn.java_session_2;

/***
 *  3. WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
 *
 */
class Car{
    private String name;
    Car(String name){
        this.name = name;
    }

    public void showName() {
        System.out.println(name);
    }
}


public class Ques3_Produce_Error {
    public static void main(String[] args) {
        try{
            Class.forName("Unknown_Class1").getName();
        }
        catch (ClassNotFoundException exp){
            System.out.println("Class Not Found Exception: " + exp.getMessage());
        }


        /*
        No Class Definition Found Error occurs when the class file is present at compile time but is not available
        or deleted at runtime.
        */
        try{
            Car c1 = new Car("BMW");
        }
        catch (NoClassDefFoundError err){
            System.out.println("Class Definition Not Found: " + err.getMessage());
        }
        System.out.println("Main Finished");
    }
}
