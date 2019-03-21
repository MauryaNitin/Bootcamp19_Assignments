package com.ttn.springboot.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * Ques 4: Create a Bean Database with two fields port and name and Access its values using application.properties
 */

public class Database {
    @Value("${database.name}")
    private String name;

    @Value("${database.port}")
    private int port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
