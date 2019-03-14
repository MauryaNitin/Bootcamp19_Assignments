package com.ttn.springAOP.Q3;

import org.springframework.context.ApplicationListener;

class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Event Listening..");
    }
}
