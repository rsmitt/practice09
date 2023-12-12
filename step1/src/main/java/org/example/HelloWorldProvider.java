package org.example;

public class HelloWorldProvider {

    public HelloWorldProvider() {
        System.out.println("HelloWorldProvider constructor without constructor initialization...");
    }

    public String getMessage() {
        return "Hello from HelloWorldProvider";
    }

    @Override
    public String toString() {
        return "HelloWorldProvider{}";
    }
}
