package com.ttn.java.designpatterns;

/**
 * 4. Implement Builder pattern to create a student object with more than 6 fields.
 */

class Student {
    private String name;
    private static int id;
    private int age;
    private char gender;
    private int grade;
    private String fatherName;
    private String academicYear;
    private String course;

    public String getName() {
        return name;
    }

    public static int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public int getGrade() {
        return grade;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getCourse() {
        return course;
    }

//    private Student(){ }

    public void setName(String name){
        this.name = name;
    }

    public void setId() {
        id++;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", gender=" + gender +
                ", grade=" + grade +
                ", fatherName='" + fatherName + '\'' +
                ", academicYear='" + academicYear + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}

class StudentBuilder{
    Student student;

    public StudentBuilder() {
        student = new Student();
        student.setId();
    }

    public StudentBuilder name(String name){
        student.setName(name);
        return this;
    }

    public StudentBuilder age(int age){
        student.setAge(age);
        return this;
    }

    public StudentBuilder gender(char gender){
        student.setGender(gender);
        return this;
    }

    public StudentBuilder grade(int grade){
        student.setGrade(grade);
        return this;
    }

    public StudentBuilder fatherName(String father){
        student.setFatherName(father);
        return this;
    }

    public StudentBuilder academicYear(String year){
        student.setAcademicYear(year);
        return this;
    }

    public StudentBuilder withCourse(String course){
        student.setCourse(course);
        return this;
    }

    public Student build(){
        return student;
    }
}

public class Ques4_Builder {
    public static void main(String[] args) {
        Student student1 = new StudentBuilder().name("Nitin Maurya").age(22).gender('M').withCourse("Computer Science").build();
        System.out.println(student1);

        Student student2 = new StudentBuilder().name("ABC").age(20).academicYear("2015").build();
        System.out.println(student2);

        Student student3 = new StudentBuilder().name("xyz").age(15).gender('F').withCourse("it").grade(12).build();
        System.out.println(student3);
    }
}
