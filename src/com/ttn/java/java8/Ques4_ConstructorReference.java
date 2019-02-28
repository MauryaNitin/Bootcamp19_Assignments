package com.ttn.java.java8;

/**
 * 4. Create an Employee Class with instance variables (String) name, (Integer)age, (String)city and get the instance of
 * the Class using constructor reference
 */
@FunctionalInterface
interface EmployeeReference {
    Employee getInstance(String name, Integer age, String city);
}

class Employee {
    private String name;
    private Integer age;
    private String city;

    Employee(String name, Integer age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}

public class Ques4_ConstructorReference {
    public static void main(String[] args) {
        EmployeeReference employeeReference = Employee::new;
        System.out.println(employeeReference.getInstance("Nitin Maurya", 22, "Delhi"));
        System.out.println(employeeReference.getInstance("Abc", 21, "Noida"));
    }
}
