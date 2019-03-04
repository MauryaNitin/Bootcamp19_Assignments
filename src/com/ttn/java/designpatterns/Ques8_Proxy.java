package com.ttn.java.designpatterns;

/**
 * 8. Implement proxy design for accessing Record of a student and allow the access only to Admin.
 */

interface AdminAccessible{
    void adminAccess();
}

class _Student implements AdminAccessible{
    private String name;
    private int totalMarks;


    public void setName(String name) {
        this.name = name;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }


    public String getName() {
        return name;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    @Override
    public String toString() {
        return "_Student{" +
                " name='" + this.getName() + '\'' +
                ", totalMarks=" + this.getTotalMarks() +
                '}';
    }

    @Override
    public void adminAccess() {
        System.out.println(this);
    }

}

class StudentProxy implements AdminAccessible{
    private _Student student;


    StudentProxy(String name, int totalMarks){
        if(student == null){
            student = new _Student();
        }
        student.setName(name);
        student.setTotalMarks(totalMarks);
    }

    @Override
    public void adminAccess() {
        student.adminAccess();
    }
}

public class Ques8_Proxy {
    public static void main(String[] args) {
        AdminAccessible s1 = new StudentProxy("Nitin", 50);
        AdminAccessible s2 = new StudentProxy("gaurav", 55);
        AdminAccessible s3 = new StudentProxy("ABC", 52);

        s1.adminAccess();
        s2.adminAccess();
        s3.adminAccess();

    }
}
