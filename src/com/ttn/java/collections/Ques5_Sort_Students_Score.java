package com.ttn.java.collections;

/**
 * 5. Write a program to sort the Student objects based on Score , if the score are same then sort on First Name . Class Student{ String Name; Double Score; Double Age
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String name;
    int age;
    double score;

    Student(String name, int age, double score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student : " +
                " Name = '" + name + '\'' +
                ", Age = " + age +
                ", Score = " + score;
    }
}

public class Ques5_Sort_Students_Score {
    public static void main(String[] args) {
        Student s1 = new Student("Nitin", 22, 77.5);
        Student s2 = new Student("Pooja", 22, 100);
        Student s3 = new Student("Gurvinder", 22, 90.5);
        Student s4 = new Student("John", 22, 84.5);
        Student s5 = new Student("Atul", 22, 77.5);

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.score == o2.score){
                    return o1.name.compareTo(o2.name);
                }
                return (int)(o1.score - o2.score);
            }
        });

        for(Student student : students){
            System.out.println(student);
        }

    }
}
