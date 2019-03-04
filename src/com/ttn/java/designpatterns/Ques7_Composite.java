package com.ttn.java.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * 7. Implement Composite Design Pattern to maintaining the directories of employees on the basis of departments.
 */

interface Directory{
    void showDirectoryDetails();
}

class Employee implements Directory{
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee(String name){
        this.id++;
        this.name = name;
    }

    @Override
    public void showDirectoryDetails() {
        System.out.println( "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}');
    }
}

class SalesDepartment implements Directory{
    private List<Directory> sales = new ArrayList<>();

    @Override
    public void showDirectoryDetails() {
        System.out.println( "SalesDepartment {" +
                " SALES_employees = " + sales +
                '}');
    }

    public SalesDepartment addEmployee(Employee e){
        sales.add(e);
        return this;
    }

    @Override
    public String toString() {
        return "SalesDepartment{" +
                "sales=" + sales +
                '}';
    }
}

class AccountingDepartment implements Directory{
    private List<Directory> accounting = new ArrayList<>();

    @Override
    public void showDirectoryDetails() {
        System.out.println( "AccountingDepartment {" +
                " ACCOUNTS_employees = " + accounting +
                '}');
    }

    public AccountingDepartment addEmployee(Employee e){
        accounting.add(e);
        return this;
    }
}


class ITDepartment implements Directory{
    private List<Directory> it = new ArrayList<>();

    @Override
    public void showDirectoryDetails() {
        System.out.println( "ITDepartment {" +
                " IT_employees = " + it +
                '}');
    }

    public ITDepartment addEmployee(Employee e){
        it.add(e);
        return this;
    }
}

public class Ques7_Composite {
    public static void main(String[] args) {
        Employee emp1 = new Employee("nitin");
        Employee emp2 = new Employee("abc");
        Employee emp3 = new Employee("XYZ");
        Employee emp4 = new Employee("jon");

        ITDepartment itDept = new ITDepartment().addEmployee(emp1).addEmployee(emp2);

        AccountingDepartment accountDept = new AccountingDepartment().addEmployee(emp3);

        SalesDepartment salesDept = new SalesDepartment().addEmployee(emp4);

        itDept.showDirectoryDetails();
        accountDept.showDirectoryDetails();
        salesDept.showDirectoryDetails();
    }
}
