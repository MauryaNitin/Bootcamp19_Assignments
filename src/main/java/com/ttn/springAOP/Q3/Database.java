package com.ttn.springAOP.Q3;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component("database")
class Database {
    private String name;
    private String port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void connect(ConfigurableApplicationContext context) {
        CustomEventPublisher eventPublisher = context.getBean("customEventPublisher", CustomEventPublisher.class);
        eventPublisher.publishEvent();
        System.out.println("Database Connection establishing with '" + name + "' on port '" + port + "'.");
    }
}
