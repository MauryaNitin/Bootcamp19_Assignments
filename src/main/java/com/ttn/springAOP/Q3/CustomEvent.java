package com.ttn.springAOP.Q3;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {
    CustomEvent(Object o) {
        super(o);
    }
}
