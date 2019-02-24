package com.ttn.java.collections;


/**
 * 4. Write a program to sort Employee objects based on highest salary using Comparator. Employee class{ Double Age; Double Salary; String Name
 */

import java.util.*;

class Employee{
     String name;
     int age;
     int salary;

    Employee(String name, int age, int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee : " +
                " Name = '" + name + '\'' +
                ", Age = " + age +
                ", Salary = " + salary;
    }
}

public class Ques4_Comparator {
    public static void main(String[] args) {
        Employee e1 = new Employee("Nitin", 22, 14000);
        Employee e2 = new Employee("Gurvinder", 23, 15100);
        Employee e3 = new Employee("Pooja", 22, 12100);
        Employee e4 = new Employee("Lalit", 22, 20100);

        List <Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.salary - o2.salary;
            }
        });

        System.out.println("Employees sorted by salary: ");

        for(Employee e : employees){
            System.out.println(e);
        }
    }
}
