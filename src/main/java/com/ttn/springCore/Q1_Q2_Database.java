
package com.ttn.springCore;

/*
 * Ques1. Create a class Database with 2 instance variables port and name. Configure Database class bean in spring container through Spring XML. Initialize instance variables using setter method.
 *
 * Ques2. Get the bean of the class from spring container and print the values of the instance variable.
 */


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Database{
    private int port;
    private String name;

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class Q1_Q2_Database {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Database db = context.getBean("database", Database.class);
        System.out.println("Database Name: " + db.getName());
        System.out.println("Database Port: " + db.getPort());
    }
}