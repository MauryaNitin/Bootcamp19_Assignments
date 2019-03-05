package com.ttn.java_session_2;


/**
 * 5. WAP to show object cloning in java using cloneable and copy constructor both.
 */

class Animal implements Cloneable{
    private String name;

    public Animal(String name){
        this.name = name;
    }

    public Animal(Animal animal){
        this.name = animal.name;
    }

    public void displayName(){
        System.out.println(this.name + '\n');
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

public class Ques5_Clone {
    public static void main(String[] args) {
        try{

            Animal dog = new Animal("Bruno");
            System.out.print("Original Dog name: ");
            dog.displayName();

            System.out.println("(Implementing Cloneable Interface)\n Dog_clone is clone of Dog : ");
            Animal dog_clone = (Animal)dog.clone();
            System.out.print("Cloned Dog name: ");
            dog_clone.displayName();

            System.out.println("(Copy Constructor)\n Dog_copy is copy of Dog : ");
            Animal dog_copy = new Animal(dog);
            System.out.print("Copied Dog name: ");
            dog_copy.displayName();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
