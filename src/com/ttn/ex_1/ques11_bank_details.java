package com.ttn.ex_1;

/**
* Q11.Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide there specific
 * details like rateofinterest etc,print details of every banks
*
 **/

abstract class Bank{
    protected String ifsc_code;
    protected String name;
    protected String branch;
    protected String city;
    protected float roi;

    abstract void getDetails();

}

class SBI extends Bank{

    SBI(String ifsc_code, String name, String branch, String city, float roi){
        this.ifsc_code = ifsc_code;
        this.name = name;
        this.branch = branch;
        this.city = city;
        this.roi = roi;
    }


    void getDetails(){
        System.out.println("IFSC_CODE: " + this.ifsc_code);
        System.out.println("Name: " + this.name);
        System.out.println("Branch: " + this.branch);
        System.out.println("City: " + this.city);
        System.out.println("Rate of Interest: " + this.roi);
    }
}

class ICICI extends Bank{

    ICICI(String ifsc_code, String name, String branch, String city, float roi){
        this.ifsc_code = ifsc_code;
        this.name = name;
        this.branch = branch;
        this.city = city;
        this.roi = roi;
    }

    void getDetails(){
        System.out.println("IFSC_CODE: " + this.ifsc_code);
        System.out.println("Name: " + this.name);
        System.out.println("Branch: " + this.branch);
        System.out.println("City: " + this.city);
        System.out.println("Rate of Interest: " + this.roi);
    }
}

class BOI extends Bank{

    BOI(String ifsc_code, String name, String branch, String city, float roi){
        this.ifsc_code = ifsc_code;
        this.name = name;
        this.branch = branch;
        this.city = city;
        this.roi = roi;
    }

    void getDetails(){
        System.out.println("IFSC_CODE: " + this.ifsc_code);
        System.out.println("Name: " + this.name);
        System.out.println("Branch: " + this.branch);
        System.out.println("City: " + this.city);
        System.out.println("Rate of Interest: " + this.roi);
    }
}



public class ques11_bank_details {
    public static void main(String[] args) {
        Bank sbi = new SBI("sbi1", "SBI", "Noida", "Noida", 7.25f);
        Bank icici = new ICICI("icici2", "ICICI", "CP", "Delhi", 14.00f);
        Bank boi = new BOI("boi3", "BOI", "GZB","GZB", 10.25f);

        sbi.getDetails();
        System.out.println("");
        icici.getDetails();
        System.out.println("");
        boi.getDetails();

    }
}
