package com.ttn.springAOP.Q3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component("customEventPublisher")
class CustomEventPublisher implements ApplicationEventPublisherAware {
    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void publishEvent(){
        CustomEvent event = new CustomEvent(this);
        eventPublisher.publishEvent(event);
        System.out.println("Custom Event Published...");
    }
}
