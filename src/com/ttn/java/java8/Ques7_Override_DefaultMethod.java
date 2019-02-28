package com.ttn.java.java8;

/**
 * 7. Override the default method of the interface.
 */

interface Animals{
    default void talk(){
        System.out.println("Animal makes sound..");
    }
}

class Dogs implements Animals{
    @Override
    public void talk(){
        System.out.println("Bark");
    }
}


public class Ques7_Override_DefaultMethod {
    public static void main(String[] args) {
        Dogs d = new Dogs();
        d.talk();
    }
}
