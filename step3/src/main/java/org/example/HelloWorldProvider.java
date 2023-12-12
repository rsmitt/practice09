package org.example;

public class HelloWorldProvider implements IMessageProvider{

    public HelloWorldProvider() {
        System.out.println("HelloWorldProvider constructor without constructor initialization...");
    }

    @Override
    public String getMessage() {
        return "Hello from HelloWorldProvider";
    }

    @Override
    public String toString() {
        return "HelloWorldProvider{}";
    }
}
