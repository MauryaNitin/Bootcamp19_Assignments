package com.ttn.java_session_2;

/**
 * 9.  Design classes having attributes for furniture where there are wooden chairs and tables, metal chairs and tables. There are stress and fire tests for each products.
 */

class Material{
    private String materialName;

    public Material(String materialName){
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }
}

abstract class Furniture{
    private Material furnitureType;
    public abstract void fireTest();
    public abstract void stressTest();

    Furniture(String type){
        this.furnitureType = new Material(type);
    }

    public String getFurnitureMaterial() {
        return furnitureType.getMaterialName();
    }
}

class Chair extends Furniture{
    public Chair(String type){
        super(type);
    }

    public void fireTest(){
        System.out.println("Performing fire test on: " + this.getFurnitureMaterial() + " Chair");
        if(this.getFurnitureMaterial().toLowerCase().equals("wooden")){
            System.out.println("-> This chair can be Burned.");
        }
        else if(this.getFurnitureMaterial().toLowerCase().equals("metal")){
            System.out.println("-> This chair cannot be Burned.");
        }
        else{
            System.out.println("-> This Chair cannot be tested.");
        }
    }

    public void stressTest(){
        System.out.println("Performing Stress test on: " + this.getFurnitureMaterial() + " Chair");
        if(this.getFurnitureMaterial().toLowerCase().equals("wooden")){
            System.out.println("-> This chair cannot be Stressed.");
        }
        else if(this.getFurnitureMaterial().toLowerCase().equals("metal")){
            System.out.println("-> This chair can be Stressed.");
        }
        else{
            System.out.println("-> This Chair cannot be tested.");
        }
    }

}

class Table extends Furniture{
    public Table(String type){
        super(type);
    }

    public void fireTest(){
        System.out.println("Performing fire test on: " + this.getFurnitureMaterial() + " Table");
        if(this.getFurnitureMaterial().toLowerCase().equals("wooden")){
            System.out.println("-> This table can be Burned.");
        }
        else if(this.getFurnitureMaterial().toLowerCase().equals("metal")){
            System.out.println("-> This table cannot be Burned.");
        }
        else{
            System.out.println("-> This Table cannot be tested.");
        }
    }

    public void stressTest(){
        System.out.println("Performing Stress test on: " + this.getFurnitureMaterial() + " Table");
        if(this.getFurnitureMaterial().toLowerCase().equals("wooden")){
            System.out.println("-> This table cannot be Stressed.");
        }
        else if(this.getFurnitureMaterial().toLowerCase().equals("metal")){
            System.out.println("-> This table can be Stressed.");
        }
        else{
            System.out.println("-> This Table cannot be tested.");
        }
    }
}

public class Ques9_Furniture {
    public static void main(String[] args) {
        new Chair("Wooden").fireTest();
        System.out.println("\n");

        new Chair("Wooden").stressTest();
        System.out.println("\n");

        new Table("Metal").stressTest();
        System.out.println("\n");

        new Table("Metal").stressTest();
        System.out.println("\n");

        new Chair("Metal").stressTest();

        new Table("abc").stressTest();
    }
}
