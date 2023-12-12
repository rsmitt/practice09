package org.example;

import org.springframework.stereotype.Component;

@Component("anotherProvider")
public class AnotherProvider implements IMessageProvider{

    public AnotherProvider() {
        System.out.println("AnotherProvider constructor without constructor initialization...");
    }

    @Override
    public String getMessage() {
        return "Some message from AnotherProvider";
    }

    @Override
    public String toString() {
        return "AnotherProvider{}";
    }
}
