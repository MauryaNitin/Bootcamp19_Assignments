package com.ttn.springAOP.Q3;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Ques 3: Create a CustomEvent which should get published when you invoke connect method of database bean.
 */

public class Q3_DatabaseCustomEvent {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Database db = context.getBean("database", Database.class);
        db.setName("SalesDB");
        db.setPort("3306");
        db.connect(context);
    }
}
