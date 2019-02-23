package com.ttn.java_session_2;


/***
 *  1.  Create Java classes having suitable attributes for Library management system.Use OOPs concepts in your design.
 *      Also try to use interfaces and abstract classes.
 */

abstract class Person{
    public String name;
    public String phone;
    public String address;

    public abstract void viewInfo();

    public Person(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}


class Student extends Person{
    private int rollno;
    public int issuedBooksCount;
    public boolean hasFine = false;

    public Book[] issuedBooks = new Book[10];

    Student(String name, int rollno, String phone, String address){
        super(name, phone, address);
        this.rollno = rollno;
    }

    public boolean requestBook(Book b){
        return Librarian.issueBook(this, b);
    }


    public void returnBook(Book b){
        Librarian.returnBook(this, b);
    }

    public static double calculateFine(Student s){
        double totalFine = 0;
        for(int i = 0; i < s.issuedBooksCount; i++){
            if(s.issuedBooks[i].isIssued && s.hasFine){
                totalFine += 10;
            }
        }
        return totalFine;
    }

    @Override
    public void viewInfo() {
        System.out.println("Student Rollno: " + this.rollno + " Name: " + this.name + " Phone: " + this.phone);
    }

}

class Librarian extends Person{
    private int empId;
    Librarian(String name, int empId, String phone, String address){
        super(name, phone, address);
        this.empId = empId;
    }

    public static boolean issueBook(Student s, Book b){
        try{
            b.isIssued = true;
            s.issuedBooks[s.issuedBooksCount] = b;
            s.issuedBooksCount++;
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Issued Max Books!");
        }
        return false;
    }

    public static void returnBook(Student s, Book b){

        for(int i = 0 ; i < s.issuedBooksCount; i++){
            if(s.issuedBooks[i] == b){
                s.issuedBooks[i] = null;
                break;
            }
        }
        b.isIssued = false;
        s.issuedBooksCount--;
    }


    public static void makeFinePayment(Student s, double fineAmount){
        if(Student.calculateFine(s) <= fineAmount){
           s.hasFine = false;
        }
    }

    @Override
    public void viewInfo() {
        System.out.println("Librarian Id: " + this.empId + " Name: " + this.name + " Phone : " + this.phone);
    }
}

class Book{
    private int id;
    public String title;
    public String publisher;
    public String author;
    public boolean isIssued = false;

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

public class Ques1_LMS {
    public static void main(String[] args) {

    }
}
